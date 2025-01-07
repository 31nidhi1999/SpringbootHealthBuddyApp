package com.health.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.health.custom_exception.ApiException;
import com.health.custom_exception.ResourceNotFoundException;
import com.health.dto.request.HospitalReqDto;
import com.health.dto.response.ApiResponse;
import com.health.dto.response.HospitalResDto;
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


	@Override
	public List<HospitalResDto> getAllHospital() {
		return hospitalRepository
				.findAll()
				.stream()
				.map((h)->mapper
						.map(h,HospitalResDto.class))
				.collect(Collectors.toList());
	}


	@Override
	public List<HospitalResDto> getActiveHospital() {
		return hospitalRepository
				.findAll()
				.stream()
				.filter(h->h.getIsActive()==true)
				.map((h)->mapper
						.map(h,HospitalResDto.class))
				.collect(Collectors.toList());
	}


	@Override
	public ApiResponse removeHospital(Long hospId) {
		
		Hospital hospital = hospitalRepository.findById(hospId)
		.orElseThrow(()->new ResourceNotFoundException("Doctor",hospId));
		hospital.setIsActive(false);
		
		return new ApiResponse(hospId +" is removed");
	}
	
	@Override
	public ApiResponse activateHospital(Long hospId) {
		hospitalRepository.findById(hospId)
		.orElseThrow(()->new ResourceNotFoundException("Doctor",hospId))
		.setIsActive(true);;
		return new ApiResponse(hospId +"is activated");
	}
	/*
	 * public ApiResponse addHospital(HospitalReqDto hospitalReqDto) { Hospital save
	 * = hospitalRepository.save(mapper.map(hospitalReqDto, Hospital.class)); return
	 * new ApiResponse("Hospital Added id ::" + save.getId()); }
	 */

}
