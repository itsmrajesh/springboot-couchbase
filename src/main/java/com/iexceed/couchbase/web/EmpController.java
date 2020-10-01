package com.iexceed.couchbase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iexceed.couchbase.model.Employee;
import com.iexceed.couchbase.service.EmployeeService;

@RestController
@RequestMapping("api/v1/emp/")
public class EmpController {

	@Autowired
	private EmployeeService service;

	@PostMapping("")
	public Employee save(@RequestBody Employee employee) {
		return service.save(employee);
	}

	@PostMapping("addall")
	public long saveAll(@RequestBody List<Employee> employees) {
		return service.addAll(employees);
	}

	@GetMapping("")
	public List<Employee> getAll() {
		return (List<Employee>) service.findAll();
	}

	@GetMapping("count")
	public long count() {
		return service.count();
	}

	@GetMapping("designation/{designation}")
	public List<Employee> getByDesignation(String designation) {
		return service.getByDesignation(designation);
	}

	@GetMapping("designation/count/{designation}")
	public Long designationCount(String designation) {
		return service.getEmployeesCountByDesignation(designation);
	}

}
