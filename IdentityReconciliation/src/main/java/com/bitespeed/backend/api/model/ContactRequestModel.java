package com.bitespeed.backend.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactRequestModel {

	@NotBlank(message = "email cannot be null or empty")
	@Email
	private String email;
	
	@NotBlank(message = "phone number cannot be null or empty")
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
