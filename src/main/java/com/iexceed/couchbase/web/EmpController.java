package com.iexceed.couchbase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iexceed.couchbase.model.Employee;
import com.iexceed.couchbase.repo.EmpRepo;

@RestController
@RequestMapping("api/v1/emp/")
public class EmpController {

	@Autowired
	private EmpRepo empRepo;

	@PostMapping("")
	public Employee addProfile(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}

	@GetMapping("")
	public List<Employee> getAll() {
		return (List<Employee>) empRepo.findAll();
	}

}
