
package com.health.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Hospital extends BaseEntity {
	
	private String name;
	private String contact;
	private String location;
	private Boolean isActive=true;
	
	@ManyToMany
	private Set<Doctor> doctor;
}

