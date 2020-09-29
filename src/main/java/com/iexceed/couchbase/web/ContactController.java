package com.iexceed.couchbase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iexceed.couchbase.model.Contact;
import com.iexceed.couchbase.service.ContactBookService;

@RestController
@RequestMapping("api/v1/cbook/")
public class ContactController {

	@Autowired
	private ContactBookService service;

	@PostMapping("")
	public Contact add(@RequestBody Contact contact) {
		return service.save(contact);
	}

	@GetMapping("")
	public List<Contact> getAll() {
		return service.findAll();
	}

	@GetMapping("{id}")
	public Contact findOne(@PathVariable String id) {
		return service.findOne(id);
	}

	@DeleteMapping("{id}")
	public void deleteOne(@PathVariable String id) {
		service.deleteOne(id);
	}

	@DeleteMapping("")
	public void deleteAll() {
		service.deleteAll();
	}

	@PutMapping("")
	public Contact update(@RequestBody Contact contact) {
		return service.update(contact);
	}

	@PostMapping("addall")
	public int saveAll(@RequestBody List<Contact> contacts) {
		return service.saveAll(contacts);
	}
	
	@GetMapping("count")
	public long getCount() {
		return service.count();
	}


}
