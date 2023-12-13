package com.thecybersphere.repo;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.thecybersphere.model.CyberSphereUser;

public interface UserRepository extends CrudRepository<CyberSphereUser, UUID> {

    Optional<CyberSphereUser> findByUserDetailsUsername(String username);

    List<CyberSphereUser> findByCreatedAtAfter(LocalDateTime date);

    List<CyberSphereUser> findByLastOnlineBefore(Instant date);

    List<CyberSphereUser> findByBioContaining(String keyword);

    List<CyberSphereUser> findByIsCreator(boolean isCreator);

    List<CyberSphereUser> findByFriendsContaining(CyberSphereUser friend);

    List<CyberSphereUser> findByUserDetailsUsernameAndLastOnline(String username, Instant lastOnline);

    List<CyberSphereUser> findAllByOrderByCreatedAtDesc();

    Page<CyberSphereUser> findAll(Pageable pageable);
}
