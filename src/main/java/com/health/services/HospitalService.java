package com.health.services;

import com.health.dto.request.HospitalReqDto;
import com.health.dto.response.ApiResponse;

import jakarta.validation.Valid;

public interface HospitalService {

	ApiResponse addHospital(@Valid HospitalReqDto hospitalDto);
	
}
