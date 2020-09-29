package com.iexceed.couchbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.iexceed.couchbase.dao.ContactDao;
import com.iexceed.couchbase.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactBookService {

	@Autowired
	private ContactDao dao;

	public Contact save(Contact contact) {
		Assert.notNull(contact, "contact object cant be null");
		contact = dao.save(contact);
		if (contact != null) {
			log.info("New Contact added with ID : {} ", contact.getId());
		} else {
			log.info("Contact failed to add");
		}
		return contact;
	}

	public List<Contact> findAll() {
		List<Contact> list = dao.findAll();
		log.info("Found {} contacts", list.size());
		return list;
	}

	public Contact findOne(String id) {
		Assert.notNull(id, "ID cant be null");

		Contact contact = dao.findOne(id);

		if (contact != null) {
			log.info("Contact found with ID : {} ", id);
		} else {
			log.info("No contact found with ID : {} ", id);
		}

		return contact;
	}

	public void deleteOne(String id) {
		Assert.notNull(id, "ID cant be null");
		if (findOne(id) != null) {
			dao.deleteOne(id);
			log.info("Contact deleted with ID : {} ", id);
		} else {
			log.info("No contact found with ID : {} to delete", id);
		}

	}

	public void deleteAll() {
		log.info("Deleteing all contacts");
		dao.deleteAll();
	}

	public Contact update(Contact contact) {
		Assert.notNull(contact, "contact object cant be null");
		contact = dao.update(contact);

		if (contact != null) {
			log.info("Update successful");
		} else {
			log.info("Update failed");
		}

		return contact;
	}

	public int saveAll(List<Contact> contacts) {
		Assert.notNull(contacts, "Contact List cant be null");
		int count = dao.saveAll(contacts);
		log.info("Added {} new contacts", count);
		return count;
	}

	public long count() {
		long totalContacts = dao.count();
		log.info("Total contacts found are {} ", totalContacts);
		return totalContacts;
	}

}
