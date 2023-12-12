package com.thecybersphere.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.thecybersphere.model.Post;

public interface PostRepository extends CrudRepository<Post, UUID> {

}
