package com.bitespeed.backend.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitespeed.backend.api.model.ContactRequestModel;
import com.bitespeed.backend.api.model.ContactResponseModel;

@RestController
@RequestMapping("/identify")
public class IdentityReconciliationContoller {

	@PostMapping
	public ResponseEntity<ContactResponseModel> identify(@RequestBody ContactRequestModel contactDetails) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
