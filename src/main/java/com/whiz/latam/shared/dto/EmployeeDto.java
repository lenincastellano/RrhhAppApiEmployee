package com.whiz.latam.shared.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {

	private int id;
	private int genderId;
	private int jobId;
	private String name;
	private String lastName;
	private String birthdate;

}
