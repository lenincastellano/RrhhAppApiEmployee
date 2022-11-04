package com.whiz.latam.shared.dto;

import com.whiz.latam.ui.model.request.EmployeeRequestModel;

public class EmployeeConverter {

	private EmployeeConverter() {}
	
	public static EmployeeDto converterDto(EmployeeRequestModel employeeDetails) {
		
		EmployeeDto employeeConvertered = new EmployeeDto();
		
		employeeConvertered.setGenderId(employeeDetails.getGender_id());
		employeeConvertered.setJobId(employeeDetails.getJob_id());
		employeeConvertered.setName(employeeDetails.getName());
		employeeConvertered.setLastName(employeeDetails.getLast_name());
		employeeConvertered.setBirthdate(employeeDetails.getBirthdate());
		
		return employeeConvertered;
	}
}
