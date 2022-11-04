package com.whiz.latam.ui.rest;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.latam.service.EmployeeService;
import com.whiz.latam.shared.dto.EmployeeConverter;
import com.whiz.latam.shared.dto.EmployeeDto;
import com.whiz.latam.ui.model.request.EmployeeRequestModel;
import com.whiz.latam.ui.model.response.EmployeeResponseModel;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeResponseModel> createEmployee(
			@Valid @RequestBody EmployeeRequestModel employeeDetalis) {

		EmployeeResponseModel response = new EmployeeResponseModel();

		EmployeeDto employeeDto = EmployeeConverter.converterDto(employeeDetalis);

		EmployeeDto employeeCreated = employeeService.createEmployee(employeeDto);
		if (employeeCreated == null) {
			response.setId(null);
			response.setSuccess(false);
		} else {
			response.setId(String.valueOf(employeeCreated.getId()));
			response.setSuccess(true);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
