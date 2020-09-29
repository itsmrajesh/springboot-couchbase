package com.iexceed.couchbase.repo;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.iexceed.couchbase.model.Contact;

@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "contact")
public interface ContactRepo extends CouchbaseRepository<Contact, String> {

}
