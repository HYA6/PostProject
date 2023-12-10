package com.assignment.postProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.postProject.entity.PostTag;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {

};
