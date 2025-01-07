package com.health.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.health.dto.request.HospitalReqDto;
import com.health.dto.response.ApiResponse;
import com.health.repositories.HospitalRepository;
import com.health.services.HospitalService;

import jakarta.validation.Valid;
import com.health.entities.Hospital;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	@Autowired
	private ModelMapper mapper;


	@Override
	public ApiResponse addHospital(HospitalReqDto hospitalDto) {
		Hospital save = hospitalRepository.save(mapper.map(hospitalDto, Hospital.class));
		
		return new ApiResponse("Hospital add succesfull with hospitalid "+save.getId());

	}
	
	/*
	 * public ApiResponse addHospital(HospitalReqDto hospitalReqDto) { Hospital save
	 * = hospitalRepository.save(mapper.map(hospitalReqDto, Hospital.class)); return
	 * new ApiResponse("Hospital Added id ::" + save.getId()); }
	 */

}
