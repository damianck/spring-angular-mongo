package com.damianck.pl.angular.repositories;

import com.damianck.pl.angular.models.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, String> {
    @Override
    Optional<Contact> findById(String id);

    @Override
    void delete(Contact deleted);
}