package com.nj.addressbook.test;

import com.nj.addressbook.entities.Contact;
import com.nj.addressbook.services.AddressBookService;
import com.nj.addressbook.utils.SpringContext;

public class SpringJDBCDemoTest {

	public static void main(String[] args) throws Exception {
		AddressBookService addressBookService = SpringContext.getBean(AddressBookService.class);
		Contact contact=new Contact();
		contact.setName("abcd");
		contact.setPhoneNumber("123456");
		contact.setEmail("admin@gmail.com");
		contact.setAddress("Kukatpally");
		
		addressBookService.createContact(contact);
	}

}
