package com.assignment.postProject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 게시물
@Entity
public class Post {
	
	@Id
	@Column(columnDefinition="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postNo; // 글번호
	@Column
	private String postSj; // 제목
	@Column
	private String postCn; // 내용
	@Column
	private String regstrId; // 작성자 ID
	@Column
	private Date regDt; // 작성일
	
};
