package com.health.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.dto.request.HospitalReqDto;
import com.health.dto.response.HospitalResDto;
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
	
	@GetMapping
	public ResponseEntity<?> getAllHospital(){
		List<HospitalResDto> allHospital = hospitalService.getAllHospital();
		if(allHospital==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(allHospital);
	} 
	
	@GetMapping("/active")
	public ResponseEntity<?> getActiveHospital(){
		List<HospitalResDto> allHospital = hospitalService.getActiveHospital();
		if(allHospital==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(allHospital);
	} 
	
	@PatchMapping("/inactivate/{hospId}")
	public ResponseEntity<?> removeHospital( @PathVariable Long hospId){
		return ResponseEntity.ok(hospitalService.removeHospital(hospId));
		
	}
	
	@PatchMapping("/activate/{hospId}")
	public ResponseEntity<?> activateHospital(@PathVariable Long hospId){
		return ResponseEntity.ok(hospitalService.activateHospital(hospId));
	}
}
