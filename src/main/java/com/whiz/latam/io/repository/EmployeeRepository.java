package com.whiz.latam.io.repository;

import org.springframework.data.repository.CrudRepository;

import com.whiz.latam.io.entity.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

	EmployeeEntity findByNameAndLastName(String name, String lastName);
}
