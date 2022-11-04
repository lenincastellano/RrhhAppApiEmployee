package com.whiz.latam.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class EmployeeRequestModel {

	@NotNull
	private int gender_id;

	@NotNull
	private int job_id;

	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	@NotNull
	@Size(min = 1, max = 255)
	private String last_name;

	@NotNull
	private String birthdate;

}
