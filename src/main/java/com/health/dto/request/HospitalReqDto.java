package com.health.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class HospitalReqDto {

	@NotNull
	private String name;
	@NotNull
	private String location;
	@NotNull
	private String contact;
}
