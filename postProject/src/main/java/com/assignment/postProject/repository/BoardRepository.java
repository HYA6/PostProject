package com.assignment.postProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.postProject.entity.Post;

public interface BoardRepository extends JpaRepository<Post, Long> {

}
