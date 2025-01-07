package com.health.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ApiResponse {
	
	private String message;
	private LocalDateTime timeStamp;
	
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	
	
}
