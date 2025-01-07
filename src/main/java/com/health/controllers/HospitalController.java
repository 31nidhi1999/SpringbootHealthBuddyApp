package com.health.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.dto.request.HospitalReqDto;
import com.health.services.HospitalService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping
	public ResponseEntity<?> addHospital(@RequestBody @Valid HospitalReqDto hospitalDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(hospitalService.addHospital(hospitalDto));
	}
}
