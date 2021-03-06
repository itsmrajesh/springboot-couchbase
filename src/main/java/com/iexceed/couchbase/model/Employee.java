package com.iexceed.couchbase.model;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Employee {

	@Id
	@GeneratedValue(strategy = UNIQUE)
	private String id;

	@Field
	private String empName;

	@Field
	private String designation;

	@Field
	private double sal;

}
