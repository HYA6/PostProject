package com.assignment.postProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.postProject.entity.BoardDef;

public interface BoardRepository extends JpaRepository<BoardDef, String> {

};
