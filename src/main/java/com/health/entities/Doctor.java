package com.health.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Doctor extends BaseEntity {
	
	@Column(name = "dr_name")
	private String name;
	private String specialization;
	private Double experience;
	
	/*We have one userid for one doctor*/
	@OneToOne
	@JoinColumn(name="User_id",nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "hospital_doctor",joinColumns = @JoinColumn(name="doctor_Id"), inverseJoinColumns = @JoinColumn(name="hospital_Id"))
	private List<Hospital> hospitals;
	
	
	
}
