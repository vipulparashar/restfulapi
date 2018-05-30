package com.rest.api.restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String favourite_colour;
    private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", favourite_colour="
				+ favourite_colour + ", age=" + age + "]";
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
