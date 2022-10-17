package com.example.demo.dto;

import lombok.Data;

@Data
public class QRCodeDTO {

	private int id;

	private int ownerId;

	private int occuranceId;

	private int guestUser;

	private long validFrom;

	private long validUpto;

}
