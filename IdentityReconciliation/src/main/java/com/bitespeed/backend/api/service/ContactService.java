package com.bitespeed.backend.api.service;

import org.springframework.stereotype.Service;

import com.bitespeed.backend.api.model.ContactRequestModel;
import com.bitespeed.backend.api.model.ContactResponseModel;

@Service
public interface ContactService {
	ContactResponseModel createContact(ContactRequestModel contactDetails);
}
