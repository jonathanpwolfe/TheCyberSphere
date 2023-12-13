package com.thecybersphere.repo;

import org.springframework.data.repository.CrudRepository;

import com.thecybersphere.model.CyberSphereUserDetails;
import java.util.Optional;
import java.util.UUID;

public interface LoginRepository extends CrudRepository<CyberSphereUserDetails, UUID> {

    Optional<CyberSphereUserDetails> findByUsername(String username);

}
