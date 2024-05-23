package com.bitespeed.backend.api.data;

import java.time.LocalDateTime;

import com.bitespeed.backend.api.shared.LinkPrecendence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ContactEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false, length = 50)
	private String phoneNumber;
	
	@Column(nullable = false, length = 150)
	private String email;
	
	@Column(nullable = true)
	private int linkedId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="linkPrecedence")
	private LinkPrecendence linkPrecedence;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	private LocalDateTime deletedAt;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLinkedId() {
		return linkedId;
	}

	public void setLinkedId(int linkedId) {
		this.linkedId = linkedId;
	}

	public LinkPrecendence getLinkPrecedence() {
		return linkPrecedence;
	}

	public void setLinkPrecedence(LinkPrecendence linkPrecedence) {
		this.linkPrecedence = linkPrecedence;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	
}
