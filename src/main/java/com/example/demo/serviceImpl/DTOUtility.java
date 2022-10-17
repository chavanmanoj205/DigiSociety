package com.example.demo.serviceImpl;

import com.example.demo.dto.QRCodeDTO;
import com.example.demo.model.OccuranceEnum;
import com.example.demo.model.QRCode;
import com.example.demo.model.User;

public class DTOUtility {

	public static QRCodeDTO convertQRCodetoDTO(QRCode qrCode) {
		QRCodeDTO dto = new QRCodeDTO();
		dto.setId(qrCode.getId());
		dto.setOwnerId(qrCode.getUser().getUid());
		dto.setOccuranceId(OccuranceEnum.convertOccuranceEnumToInt(qrCode.getOccurance()));
		dto.setGuestUser(qrCode.getGuestUser().getUid());
		dto.setValidFrom(qrCode.getValidFrom());
		dto.setValidUpto(qrCode.getValidUpto());
		
		return dto;
	}

	public static QRCode convertQRCodeDTOtoQRCode(QRCodeDTO dto, User user, User guestUser) {
		
		QRCode qrCode = new QRCode();
		qrCode.setId(dto.getId());
		qrCode.setValidFrom(dto.getValidFrom());
		qrCode.setValidUpto(dto.getValidUpto());
		qrCode.setUser(user);
		qrCode.setGuestUser(guestUser);
		qrCode.setOccurance(OccuranceEnum.convertIntToOccuranceEnum(dto.getOccuranceId()));
		
		return qrCode;
		
	}

}
