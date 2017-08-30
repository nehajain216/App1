package com.nj.addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.addressbook.dao.AddressBookDAO;
import com.nj.addressbook.dao.AuditDAO;
import com.nj.addressbook.entities.Contact;

@Service
public class AddressBookService 
{
	private AddressBookDAO addressBookDAO;
	private AuditDAO auditDAO;
	
	public Contact createDuplicateContacts(Contact contact) {
		return addressBookDAO.createDuplicateContacts(contact);
	}

	@Autowired
	public AddressBookService(AddressBookDAO addressBookDAO,AuditDAO auditDAO) {
		super();
		this.addressBookDAO = addressBookDAO;
		this.auditDAO = auditDAO;
	}

	public List<Contact> getAllContacts() {
		return addressBookDAO.getAllContacts();
	}

	public Contact getContactById(int id) {
		return addressBookDAO.getContactById(id);
	}

	@Transactional(rollbackFor=Exception.class)
	public Contact createContact(Contact contact) throws Exception {
		auditDAO.createAudit("creating contact with name:-"+contact.getName());
		
		Contact createdContact = addressBookDAO.createContact(contact);
		if(1==1){
			throw new Exception("Testing transaction new");
		}
		return createdContact;
	}
	
}
