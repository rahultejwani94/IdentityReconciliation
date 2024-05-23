package com.bitespeed.backend.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bitespeed.backend.api.data.ContactEntity;

public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {

	@Query("select c from ContactEntity c where c.email = :email or c.phoneNumber = :phoneNumber order by c.createdAt")
	public List<ContactEntity> findByEmailOrPhoneNumber(String email, String phoneNumber);
	public List<ContactEntity> findByEmail(String email);
}
