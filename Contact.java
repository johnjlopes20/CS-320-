/*
 * Copyright (c) 2024, John Lopes 
 */


public class Contact {

  private static final int CONTACT_PHONENUM_LENGTH = 10;
  private static final byte CONTACT_ID_LENGTH = 10;
  private static final byte CONTACT_FNAME_LENGTH = 10;
  private static final byte CONTACT_LNAME_LENGTH = 10;
  private static final byte CONTACT_ADDRESS_LENGTH = 30;
  private static final String INITIALIZER_NUM = "6553331235";
  private String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

  public Contact(String firstName, String lastName, String phoneNumber, String address) {
    this.contactId = generateUniqueId(); 
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    updateAddress(address);
  }

 
  public String getContactId() { return contactId; }
  public String getFirstName() { return firstName; }
  public String getLastName() { return lastName; }
  public String getPhoneNumber() { return phoneNumber; }
  public String getAddress() { return address; }

 
  public void updateFirstName(String firstName) {
    validateName(firstName);
    this.firstName = firstName;
  }

 
  public void updateLastName(String lastName) {
    validateName(lastName);
    this.lastName = lastName;
  }

  
  public void updatePhoneNumber(String phoneNumber) {
    validatePhoneNumber(phoneNumber);
    this.phoneNumber = phoneNumber;
  }

 
  public void updateAddress(String address) {
    validateAddress(address);
    this.address = address;
  }

  
  private String generateUniqueId() {
    return "generated_id";
  }

  
  private void validateName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    }
    if (name.length() > CONTACT_FNAME_LENGTH) {
      throw new IllegalArgumentException("Name cannot be longer than " + CONTACT_FNAME_LENGTH + " characters.");
    }
  }

  
  private void validatePhoneNumber(String phoneNumber) {
    if (phoneNumber == null || phoneNumber.isEmpty()) {
      throw new IllegalArgumentException("Phone number cannot be null or empty.");
    }
    if (phoneNumber.length() != CONTACT_PHONENUM_LENGTH) {
      throw new IllegalArgumentException("Phone number must be exactly " + CONTACT_PHONENUM_LENGTH + " digits.");
    }
    if (!phoneNumber.matches("\\d+")) {
      throw new IllegalArgumentException("Phone number must contain only digits.");
    }
  }

  
  private void validateAddress(String address) {
    if (address == null || address.isEmpty()) {
      throw new IllegalArgumentException("Address cannot be null or empty.");
    }
    if (address.length() > CONTACT_ADDRESS_LENGTH) {
      throw new IllegalArgumentException("Address cannot be longer than " + CONTACT_ADDRESS_LENGTH + " characters.");
    }
  }
}

