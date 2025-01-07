package com.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
