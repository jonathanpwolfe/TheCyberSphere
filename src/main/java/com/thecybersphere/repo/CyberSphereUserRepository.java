package com.thecybersphere.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thecybersphere.model.CyberSphereUser;

                                      
public interface CyberSphereUserRepository extends CrudRepository<CyberSphereUser, UUID> {
    Optional<CyberSphereUser> findByUsername(String username);

    List<CyberSphereUser> findByCreatedAtAfter(Date date);

    List<CyberSphereUser> findByLastOnlineBefore(Date date);

    List<CyberSphereUser> findByBioContaining(String keyword);

    List<CyberSphereUser> findByIsCreator(boolean isCreator);

    List<CyberSphereUser> findByFriendsContaining(CyberSphereUser friend);

    List<CyberSphereUser> findByUsernameAndLastOnline(String username, Date lastOnline);
 

    List<CyberSphereUser> findAllByOrderByCreatedAtDesc();

    Page<CyberSphereUser> findAll(Pageable pageable);
}
