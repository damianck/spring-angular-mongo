package com.damianck.pl.angular.controllers;

import com.damianck.pl.angular.models.Contact;
import com.damianck.pl.angular.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/contacts")
    public Iterable<Contact> contacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/contacts")
    public Contact save(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/contacts/{id}")
    public Contact show(@PathVariable String id) {
        return contactRepository.findById(id).orElse(null);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/contacts/{id}")
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        Contact currentContact = contactRepository.findById(id).orElse(null);
        if(contact.getName() != null)
            currentContact.setName(contact.getName());
        if(contact.getAddress() != null)
            currentContact.setAddress(contact.getAddress());
        if(contact.getCity() != null)
            currentContact.setCity(contact.getCity());
        if(contact.getPhone() != null)
            currentContact.setPhone(contact.getPhone());
        if(contact.getEmail() != null)
            currentContact.setEmail(contact.getEmail());
        contactRepository.save(currentContact);
        return contact;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
    public String delete(@PathVariable String id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        contactRepository.delete(contact);

        return "";
    }
}
