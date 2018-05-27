package com.rest.api.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rest.api.restapi.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
