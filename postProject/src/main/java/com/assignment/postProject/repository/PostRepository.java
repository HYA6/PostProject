package com.assignment.postProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.postProject.entity.Post;
import com.assignment.postProject.entity.PostId;

public interface PostRepository extends JpaRepository<Post, PostId> {

};
