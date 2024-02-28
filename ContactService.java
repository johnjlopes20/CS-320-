/*
 * Copyright (c) 2024, John Lopes 
 */


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

  private List<Contact> contactList = new ArrayList<>();

  public void newContact(String firstName, String lastName, String phoneNumber, String address) {
    Contact contact = new Contact(firstName, lastName, phoneNumber, address);
    contactList.add(contact);
  }

  public void deleteContact(String id) throws Exception {
    Contact contactToRemove = searchForContact(id);
    contactList.remove(contactToRemove);
  }

  public void updateFirstName(String id, String firstName) throws Exception {
    Contact contactToUpdate = searchForContact(id);
    contactToUpdate.updateFirstName(firstName);
  }

  public void updateLastName(String id, String lastName) throws Exception {
    Contact contactToUpdate = searchForContact(id);
    contactToUpdate.updateLastName(lastName);
  }

  public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
    Contact contactToUpdate = searchForContact(id);
    contactToUpdate.updatePhoneNumber(phoneNumber);
  }

  public void updateAddress(String id, String address) throws Exception {
    Contact contactToUpdate = searchForContact(id);
    contactToUpdate.updateAddress(address);
  }

  protected List<Contact> getContactList() { return contactList; }

  private Contact searchForContact(String id) throws Exception {
    for (Contact contact : contactList) {
      if (contact.getContactId().equals(id)) {
        return contact;
      }
    }
    throw new Exception("Contact with ID " + id + " not found.");
  }
}

