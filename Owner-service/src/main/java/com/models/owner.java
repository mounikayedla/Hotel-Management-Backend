package com.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="owner")
public class owner {
	@Id
 private String ownerId;
 private String name;
 private String email;
 private String contact;
 private String address;
public String getOwnerId() {
	return ownerId;
}
public void setOwnerId(String ownerId) {
	this.ownerId = ownerId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "owner [ownerId=" + ownerId + ", name=" + name + ", email=" + email + ", contact=" + contact + ", address="
			+ address + "]";
}
public owner(String ownerId, String name, String email, String contact, String address) {
	super();
	this.ownerId = ownerId;
	this.name = name;
	this.email = email;
	this.contact = contact;
	this.address = address;
}

}
