package com.cox.auto.mobility.app.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class ExceptionResponse {

	private List<ApplicationError> errors = Lists.newArrayList();

	public List<ApplicationError> getErrors() {
		return Collections.unmodifiableList(this.errors);
	}

	public void setErrors(final List<ApplicationError> errors) {
		this.errors = new ArrayList<>(errors);
	}
}
