package com.bitespeed.backend.api.model;

import jakarta.validation.constraints.Email;

public class ContactRequestModel {

	@Email
	private String email;
	
	private String phoneNumber;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
