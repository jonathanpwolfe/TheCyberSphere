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

import com.thecybersphere.model.User;

public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    List<User> findByCreatedAtAfter(Date date);

    List<User> findByLastOnlineBefore(Date date);

    List<User> findByBioContaining(String keyword);

    List<User> findByIsCreator(boolean isCreator);

    List<User> findByFriendsContaining(User friend);

    List<User> findByUsernameAndLastOnline(String username, Date lastOnline);

    @Query("SELECT u FROM User u WHERE u.username LIKE %:keyword%")
    List<User> findByKeyword(@Param("keyword") String keyword);

    List<User> findAllByOrderByCreatedAtDesc();

    Page<User> findAll(Pageable pageable);
}
