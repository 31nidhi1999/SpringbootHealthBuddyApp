package com.health.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.dto.request.DoctorReqDto;
import com.health.dto.response.ApiResponse;
import com.health.dto.response.DoctorResDto;
import com.health.services.IDoctorService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("doctor")
@Validated
public class DoctorController {
	
	@Autowired
	private IDoctorService doctorService;
	
	@PostMapping
	public ResponseEntity<?> addDoctor(@RequestBody @Valid DoctorReqDto doctorReqDto){
		ApiResponse response = doctorService.addDoctor(doctorReqDto);
		return ResponseEntity.status(response.getResponseStatus()).body(response);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllDoctor(){
		List<DoctorResDto> allDoctor = doctorService.getAllDoctor();
		if(allDoctor==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(allDoctor);
	}
	
	@GetMapping("/active")
	public ResponseEntity<?> getAllActiveDoctor(){
		List<DoctorResDto> allDoctor = doctorService.getAllActiveDoctor();
		if(allDoctor==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(allDoctor);
	}
	
	
	@GetMapping("/inactive/{doctId}")
	public ResponseEntity<?> removeDoctor(@PathVariable Long doctId){
		 
		return ResponseEntity.ok(doctorService.removeDoctor(doctId));
	}
	
	@GetMapping("/active/{doctId}")
	public ResponseEntity<?> activateDoctor(@PathVariable Long doctId){
		 
		return ResponseEntity.ok(doctorService.activateDoctor(doctId));
	}
	
}
