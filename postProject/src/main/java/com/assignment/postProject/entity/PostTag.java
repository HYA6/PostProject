package com.assignment.postProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 게시물 태그
@Entity
public class PostTag {
	
	@Id
	@Column(columnDefinition="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boardTagId; // 게시물 태그 ID
	
};
