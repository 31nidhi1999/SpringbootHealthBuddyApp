package com.health.services;

import java.util.List;

import com.health.dto.request.DoctorReqDto;
import com.health.dto.response.ApiResponse;
import com.health.dto.response.DoctorResDto;

import jakarta.validation.Valid;

public interface IDoctorService {

	ApiResponse addDoctor(@Valid DoctorReqDto doctorReqDto);

	List<DoctorResDto> getAllDoctor();

	ApiResponse removeDoctor(Long doctId);

	ApiResponse activateDoctor(Long doctId);

	List<DoctorResDto> getAllActiveDoctor();

}
