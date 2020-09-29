package com.iexceed.couchbase.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iexceed.couchbase.model.Contact;
import com.iexceed.couchbase.repo.ContactRepo;

@Component
public class CouchBaseimpl implements ContactDao {

	@Autowired
	private ContactRepo repo;

	@Override
	public Contact save(Contact contact) {
		return repo.save(contact);
	}

	@Override
	public List<Contact> findAll() {
		return (List<Contact>) repo.findAll();
	}

	@Override
	public Contact findOne(String id) {
		Optional<Contact> obj = repo.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public void deleteOne(String id) {
		repo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public Contact update(Contact contact) {
		return repo.save(contact);
	}

	@Override
	public int saveAll(List<Contact> contacts) {
		int count = 0;

		Iterator<Contact> it = repo.saveAll(contacts).iterator();

		while (it.hasNext()) {
			count++;
			it.next();
		}

		return count;
	}

	@Override
	public long count() {
		return repo.count();
	}

}
