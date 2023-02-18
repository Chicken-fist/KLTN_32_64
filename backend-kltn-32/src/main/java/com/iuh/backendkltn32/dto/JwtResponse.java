package com.iuh.backendkltn32.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String tenTaiKhoan;
	private String roles;


	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

}
