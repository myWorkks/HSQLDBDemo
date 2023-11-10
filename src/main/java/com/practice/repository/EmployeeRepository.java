package com.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.practice.entity.Employee;

public interface EmployeeRepository  extends CrudRepository<Employee, Integer>{

}
