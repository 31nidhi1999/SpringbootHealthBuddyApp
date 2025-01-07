package com.health.services;

import java.util.List;

import com.health.dto.request.HospitalReqDto;
import com.health.dto.response.ApiResponse;
import com.health.dto.response.HospitalResDto;
import com.health.entities.Hospital;

import jakarta.validation.Valid;

public interface HospitalService {

	ApiResponse addHospital(@Valid HospitalReqDto hospitalDto);

	List<HospitalResDto> getAllHospital();

	List<HospitalResDto> getActiveHospital();

	ApiResponse removeHospital(Long hospId);

	ApiResponse activateHospital(Long hospId);
	
}
