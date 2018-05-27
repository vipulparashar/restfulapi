package com.rest.api.restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Person")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String favourite_colour;
    private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFavourite_colour() {
		return favourite_colour;
	}
	public void setFavourite_colour(String favourite_colour) {
		this.favourite_colour = favourite_colour;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

   
}
