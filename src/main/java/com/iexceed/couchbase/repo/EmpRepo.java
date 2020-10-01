package com.iexceed.couchbase.repo;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.iexceed.couchbase.model.Employee;

@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "employee")
public interface EmpRepo extends CouchbasePagingAndSortingRepository<Employee, String> {
	
	List<Employee> findByDesignation(String designation);
	
	@Query("SELECT COUNT(*) AS count FROM #{#n1ql.bucket} WHERE #{#n1ql.filter} and designation = $1")
	Long countEmployeesByDesignation(String designation);

}
