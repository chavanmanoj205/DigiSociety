package com.example.demo.serviceImpl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.QRCodeDTO;
import com.example.demo.model.QRCode;
import com.example.demo.model.User;
import com.example.demo.repo.ScannerRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.ScannerService;
import com.example.util.AESEncryptionDecryptionUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Service
public class ScannerServiceImpl implements ScannerService {

	private static final Logger LOGGER = LogManager.getLogger(ScannerServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScannerRepository scannerRepository;

	@Override
	public String createScanner(QRCodeDTO qrCode) {
		try {
			User user = userRepository.getReferenceById(qrCode.getOwnerId());

			User guestUser = userRepository.getReferenceById(qrCode.getGuestUser());

			QRCode code = DTOUtility.convertQRCodeDTOtoQRCode(qrCode, user, guestUser);

			final AESEncryptionDecryptionUtil aesEncryption = new AESEncryptionDecryptionUtil();

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

			ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(code);
			LOGGER.info("QrCode Data :" + json);
			String encryptedString = aesEncryption.encrypt(json);
			LOGGER.info("QrCode Data encryptedString :" + json);
			code.setEncryptedData(encryptedString);
			
			//File name and Directory to store the Scanner
			String path = "ScannerImages";
			File folder = new File(path);

			if (!folder.exists()) {
				folder.mkdir();
			}
			String filePath = folder.getAbsolutePath()+File.separator+code.getGuestUser().getContactNo() + ".png";
			code.setFileLocation(filePath);
			
			String charset = "UTF-8"; // or "ISO-8859-1"
			Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			BitMatrix matrix = new MultiFormatWriter().encode(new String(encryptedString.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, 200, 200, hintMap);
			MatrixToImageWriter.writeToPath(matrix, filePath.substring(filePath.lastIndexOf('.') + 1),
					new File(filePath).toPath());
			
			//Mail Sent/ SMS sent with PINCODE 
			
			scannerRepository.save(code);
			System.out.println("QR Code image created successfully as: " + filePath);
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

}
