package com.iexceed.couchbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.iexceed.couchbase.model.Employee;
import com.iexceed.couchbase.repo.EmpRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

	@Autowired
	private EmpRepo empRepo;

	public Employee save(Employee employee) {
		Assert.notNull(employee, "Employee object cant be null");
		log.info("New employee added");
		return empRepo.save(employee);
	}

	public List<Employee> findAll() {
		return (List<Employee>) empRepo.findAll();
	}

	public long count() {
		long count = empRepo.count();
		log.info("Found {} employees", count);
		return count;
	}

	public long addAll(List<Employee> employees) {
		employees = (List<Employee>) empRepo.saveAll(employees);
		log.info("Added {} employees data ", employees.size());
		return employees.size();
	}

	public List<Employee> getByDesignation(String designation) {
		List<Employee> list = empRepo.findByDesignation(designation);
		log.info("Found {} employees for designation {} ", list.size(), designation);
		return list;
	}

	public Long getEmployeesCountByDesignation(String designation) {
		long count = empRepo.countEmployeesByDesignation(designation);
		log.info("Found {} employees for designation {} ", count, designation);
		return count;
	}

}
