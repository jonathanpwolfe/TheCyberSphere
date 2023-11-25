package com.thecybersphere.repo;

import org.springframework.data.repository.CrudRepository;

import com.thecybersphere.model.User;

public interface UserRepository extends CrudRepository<User, UUID> {

}
