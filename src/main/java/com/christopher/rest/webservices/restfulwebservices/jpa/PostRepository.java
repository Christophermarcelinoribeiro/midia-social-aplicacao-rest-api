package com.christopher.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christopher.rest.webservices.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{

}
