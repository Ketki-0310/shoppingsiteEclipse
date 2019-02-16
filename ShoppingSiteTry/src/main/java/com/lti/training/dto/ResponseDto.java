package com.lti.training.dto;

import com.lti.training.entity.enums.ResponseType;

public class ResponseDto {
	private ResponseType response;// enum
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ResponseType getResponse() {
		return response;
	}

	public void setResponse(ResponseType response) {
		this.response = response;
	}

}
