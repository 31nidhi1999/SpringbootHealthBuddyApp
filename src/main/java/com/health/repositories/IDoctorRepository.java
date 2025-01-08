package com.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entities.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

}
