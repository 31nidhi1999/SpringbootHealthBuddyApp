package com.health.dto.response;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorResDto {
	private Long id;
	private String name;
	private String specialization;
	private Integer experience;
	private String email;
}
