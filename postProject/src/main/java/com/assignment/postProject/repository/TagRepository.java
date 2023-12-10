package com.assignment.postProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.postProject.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

};
