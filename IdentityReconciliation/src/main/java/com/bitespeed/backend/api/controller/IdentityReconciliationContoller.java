package com.bitespeed.backend.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitespeed.backend.api.model.ContactRequestModel;
import com.bitespeed.backend.api.model.ContactResponseModel;
import com.bitespeed.backend.api.service.ContactService;


@RestController
@RequestMapping("/identify")
public class IdentityReconciliationContoller {

	@Autowired
	private ContactService contactService;
	
	@PostMapping
	public ResponseEntity<ContactResponseModel> identify(@RequestBody ContactRequestModel contactDetails) {
		ContactResponseModel contactResponse = contactService.createContact(contactDetails);
		return new ResponseEntity<>(contactResponse, HttpStatus.OK);
	}
	
}
