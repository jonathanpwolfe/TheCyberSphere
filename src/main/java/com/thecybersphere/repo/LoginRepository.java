package com.thecybersphere.repo;

import org.springframework.data.repository.CrudRepository;

import com.thecybersphere.model.UserInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoginRepository extends CrudRepository<UserInfo, UUID> {

    Optional<UserInfo> findByUsername(String username);

}
