package com.rest.api.restapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Mongo;
import com.rest.api.restapi.model.Person;
import com.rest.api.restapi.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	ObjectMapper OBJECT_MAPPER;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value= "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Person> ReadMany(@PathVariable  String id) {
    	
    	System.out.println("Input of Read records : " +id );
    	
    	
    	return  userRepository.findById(id);
 
    }
    

    @RequestMapping(value= "/getAll", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> ReadMany() {
    	
    	System.out.println("Returning All Records : " );
    	
    	
    	return  userRepository.findAll();
 
    }
    
//    @RequestMapping(value= "/getByFirstName/{name}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public List<Person> Readcustom(@PathVariable String name) {
//    	
//    	System.out.println("Returning All Records  by Name: " );
//    	
//    	
//    	return  userRepository.findByFirst_Name(name);
// 
//    }
    
    
    
//    @RequestMapping(value= "/getByAllName/{firstname}/{lastname}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public List<Person> Readcustom(@PathVariable String firstname ,@PathVariable String lastname) {
//    	
//    	System.out.println("Returning All Records  First Name: " +firstname );
//    	System.out.println("Returning All Records  last Name: " +lastname);
//    	
//    	
//    	return  userRepository.findByFirst_NameAndLast_Name(firstname , lastname);
// 
//    }
  
    @RequestMapping(value= "/bulk", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createMany(@RequestBody String records) {
    	
    	System.out.println("Input of Bulk : " +records );
    	
    	String inputRecords = new String("");
    	try {
			JsonNode personNode = OBJECT_MAPPER.readTree(records);
		 inputRecords=	personNode.path("person").toString();
		System.out.println("Records With Header Person :"+inputRecords);
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	//ArrayList<User> users =  OBJECT_MAPPER.readValue(records, User.class);
    	TypeReference<List<Person>> mapType = new TypeReference<List<Person>>() {};
    	List<Person> users;
		try {
			users = OBJECT_MAPPER.readValue(inputRecords, mapType);	
			
			
		    userRepository.saveAll(users);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       
    }
    
    
    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteMany(@PathVariable String id ) {
    	
    	System.out.println("Input of Delete : " +id );
    	

				 userRepository.deleteById(id); 	
       
    }

    // Function to GET a single record.
    //@RequestMapping(value = "/{id}") 
    //public Optional<Person> read(@PathVariable String id) {
        //return userRepository.findById(id);
    //}
    
    // Function to POST a single record
    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public void create(@RequestBody Person user) {
    	
        //userRepository.save(user);
    //}
    
    
    // Function to PUT a single record.
    //@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public void update(@RequestBody Person user) {
        //userRepository.save(user);
    //}

    
    // Function to DELETE a single record.
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
    //public void delete(@PathVariable String id) {
        //userRepository.deleteById(id);
    //}
    
    

}
