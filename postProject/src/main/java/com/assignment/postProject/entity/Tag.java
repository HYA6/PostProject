package com.assignment.postProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 태그
@Entity
public class Tag {
	
	@Id
	@Column(columnDefinition="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagNo; // 태그 ID
	@Column
	private String tag; // 태그
	
};
