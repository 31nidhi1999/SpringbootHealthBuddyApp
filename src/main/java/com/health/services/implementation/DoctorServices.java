package com.health.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.health.custom_exception.ResourceNotFoundException;
import com.health.dto.request.DoctorReqDto;
import com.health.dto.response.ApiResponse;
import com.health.dto.response.DoctorResDto;
import com.health.entities.Doctor;
import com.health.entities.User;
import com.health.entities.UserRole;
import com.health.repositories.IDoctorRepository;
import com.health.repositories.IUserRepository;
import com.health.services.IDoctorService;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class DoctorServices implements IDoctorService {
	
	@Autowired
	private IDoctorRepository doctorRep;
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addDoctor( DoctorReqDto doctorReqDto) {
		
		Doctor doctor = mapper.map(doctorReqDto, Doctor.class);
		
		if(userRepo.existsByEmail(doctorReqDto.getEmail())){
			return new ApiResponse("Doctor exist",HttpStatus.CONFLICT);
		}
				
		User user = new User(doctorReqDto.getEmail(),doctorReqDto.getContact(),doctorReqDto.getPassword(),UserRole.ROLE_DOCTOR,true);
		userRepo.save(user);
		doctor.setUser(user);
		Long id = doctorRep.save(doctor).getId();
		return new ApiResponse("Doctor Added "+ id,HttpStatus.CREATED);
	}

	@Override
	public List<DoctorResDto> getAllDoctor() {
		return doctorRep.findAll()
			.stream()
			.map(d->mapper.map(d, DoctorResDto.class))
			.collect(Collectors.toList());
		
	}
	
	@Override
	public List<DoctorResDto> getAllActiveDoctor() {
		return doctorRep.findAll()
				.stream()
				.filter(d->d.getUser().getIsActive()==true)
				.map(d->mapper.map(d, DoctorResDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse removeDoctor(Long doctId) {
		Doctor doctor = doctorRep.findById(doctId)
		.orElseThrow(()->new ResourceNotFoundException("Doctor", doctId,HttpStatus.NOT_FOUND));
		doctor.getUser().setIsActive(false);
		return new ApiResponse("Doctor Deactivated "+doctId,HttpStatus.OK);
	}

	@Override
	public ApiResponse activateDoctor(Long doctId) {
		Doctor doctor = doctorRep.findById(doctId)
				.orElseThrow(()->new ResourceNotFoundException("Doctor", doctId,HttpStatus.NOT_FOUND));
				doctor.getUser().setIsActive(true);
		return new ApiResponse("Doctor Activated "+doctId,HttpStatus.OK);
		
	}

}
