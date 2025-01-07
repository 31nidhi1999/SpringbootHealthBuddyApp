package com.health.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseEntity {
	
	private String name;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	/*We have one userid for one doctor*/
	@OneToOne
	@JoinColumn(name="User_id",nullable = false)
	private User user;
	
	/*one pateint can have multiple appoitment*/
	@OneToMany(mappedBy = "patient")
	@Column(name = "patient_id" , nullable = false)
	private List<Appointment> appointments;
}
