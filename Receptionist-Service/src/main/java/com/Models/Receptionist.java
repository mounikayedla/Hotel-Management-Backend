package com.Models;

public class Receptionist {
	private int id;
private String name;
private String email;
private int contact;
private int salary;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public int getContact() {
	return contact;
}
public void setContact(int contact) {
	this.contact = contact;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public Receptionist(int id, String name, String email, int contact, int salary) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.contact = contact;
	this.salary = salary;
}

}
