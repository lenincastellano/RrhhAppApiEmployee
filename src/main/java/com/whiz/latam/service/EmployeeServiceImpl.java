package com.whiz.latam.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.whiz.latam.io.entity.EmployeeEntity;
import com.whiz.latam.io.repository.EmployeeRepository;
import com.whiz.latam.shared.dto.EmployeeDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		EmployeeEntity entityToSave = modelMapper.map(employeeDto, EmployeeEntity.class);

		if (isMayorEdad(employeeDto.getBirthdate())) {
			EmployeeEntity existEntity = employeeRepository.findByNameAndLastName(employeeDto.getName(),
					employeeDto.getLastName());
			try {
				if (existEntity == null) {
					EmployeeEntity employeeSaved = employeeRepository.save(entityToSave);
					return modelMapper.map(employeeSaved, EmployeeDto.class);
				}
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	private boolean isMayorEdad(String fechaNacimiento) {

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formato);
		Period periodo = Period.between(fechaNac, LocalDate.now());

		return periodo.getYears() > 18;
	}

}
