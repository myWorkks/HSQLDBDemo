package com.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Employee;
import com.practice.repository.EmployeeRepository;

@RequestMapping(value = "hsql")
@RestController
public class HSQLController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(value = "/check")
	public String check() {
		return "check working";
	}

	@GetMapping(value = "/employees")
	public List<Employee> getEmployees() {
		List<Employee> ll = new ArrayList<Employee>();
		Iterable<Employee> e = employeeRepository.findAll();
		if (e instanceof List) {
			List<Employee> l = (List) e;
			if (l.isEmpty())
				throw new RuntimeException("no employee found");
			l.stream().forEach(e1 -> {
				ll.add(e1);
			});
			return ll;

		}
		return null;
	}

	@PostMapping(value = "/register")
	public String registerEmployee(@RequestBody Employee e) {

		return "employee registered successfully with empid " + employeeRepository.save(e).getEmpId();
	}
}
