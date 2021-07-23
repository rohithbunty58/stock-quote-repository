package com.cox.auto.mobility.app.handler;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationError {

	private HttpStatus code;
	private String message;

}
