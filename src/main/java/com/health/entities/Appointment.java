package com.health.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Appointment extends BaseEntity {
	
	@Column(name="appoitment_date",nullable = false)
	private LocalDate appointmentdate;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id",nullable = false)
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="hospital_id",nullable = false)
	private Hospital hospital;
	
	@ManyToOne
	@JoinColumn(name="patient_id",nullable = false)
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name="time_slot_id",unique = true,nullable = false)
	private TimeSlot slot;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;
	
}
