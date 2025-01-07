package com.health.services.implementation;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entities.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

}
