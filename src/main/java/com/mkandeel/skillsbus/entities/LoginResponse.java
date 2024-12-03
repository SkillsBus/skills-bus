package com.mkandeel.skillsbus.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
	@JsonProperty("account type")
	private int account_type;

	public LoginResponse(int account_type) {
		this.account_type = account_type;
	}
	
	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}
}
