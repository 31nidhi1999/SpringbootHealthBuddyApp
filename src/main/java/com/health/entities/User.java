package com.health.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class User  extends BaseEntity{
	

	@Column(name="user_name",unique = true,nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false,unique = true)
	private String contactNumber;
	private Boolean isActive = true;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	public User(String email2, String contact, String password, UserRole role, boolean b) {
		this.email=email2;
		this.contactNumber=contact;
		this.userRole = role;
		this.isActive=b;
		this.password=password;
	}
	
	
}
