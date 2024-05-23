package com.bitespeed.backend.api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitespeed.backend.api.data.ContactEntity;
import com.bitespeed.backend.api.model.ContactRequestModel;
import com.bitespeed.backend.api.model.ContactResponseModel;
import com.bitespeed.backend.api.repository.ContactRepository;
import com.bitespeed.backend.api.shared.LinkPrecendence;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	public ContactResponseModel getContactResponse(int primaryContactId, List<String> emails, List<String> phoneNumbers, List<Integer> secondaryContactIds) {
		ContactResponseModel contactResponse = new ContactResponseModel();
		contactResponse.setEmails(emails);
		contactResponse.setPhoneNumbers(phoneNumbers);
		contactResponse.setPrimaryContactId(primaryContactId);
		contactResponse.setSecondaryContactIds(secondaryContactIds);
		return contactResponse;
	}
	
	@Override
	public ContactResponseModel createContact(ContactRequestModel contactDetails) {
		List<ContactEntity> listOfContacts = contactRepository.findByEmailOrPhoneNumber(contactDetails.getEmail(), contactDetails.getPhoneNumber());
		
		if(listOfContacts.isEmpty()) {
			ContactEntity contactEntity = new ContactEntity();
			LocalDateTime currentTime = LocalDateTime.now();
			contactEntity.setEmail(contactDetails.getEmail());
			contactEntity.setPhoneNumber(contactDetails.getPhoneNumber());
			contactEntity.setCreatedAt(currentTime);
			contactEntity.setUpdatedAt(currentTime);
			contactEntity.setLinkPrecedence(LinkPrecendence.primary);
			// save the contactEntity
			contactRepository.save(contactEntity);
			// get the generated id for the corresponding contact
			int generatedId = contactRepository.findByEmail(contactDetails.getEmail()).get(0).getId();
			// get the contactresponse
			ContactResponseModel contactResponse = getContactResponse(generatedId, new ArrayList<>(Arrays.asList(contactEntity.getEmail())), new ArrayList<>(Arrays.asList(contactEntity.getPhoneNumber())), new ArrayList<>());
			return contactResponse;
		}
		return null;
	}
	
}
