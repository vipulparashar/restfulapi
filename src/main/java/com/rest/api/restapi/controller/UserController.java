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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.restapi.model.User;
import com.rest.api.restapi.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	ObjectMapper OBJECT_MAPPER;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user) {
    	
        userRepository.save(user);
    }
    
    
    @RequestMapping(value= "/bulk", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createMany(@RequestBody String records) {
    	
    	System.out.println("Input of Bulk : " +records );
    	
    	//ArrayList<User> users =  OBJECT_MAPPER.readValue(records, User.class);
    	TypeReference<List<User>> mapType = new TypeReference<List<User>>() {};
    	List<User> users;
		try {
			users = OBJECT_MAPPER.readValue(records, mapType);
		    userRepository.saveAll(users);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       
    }

    @RequestMapping(value = "/{id}") 
    public Optional<User> read(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        userRepository.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
    public void delete(@PathVariable String id) {
        userRepository.deleteById(id);
    }
    
    

}
