package com.assignment.postProject.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

// 게시물
@SuppressWarnings("serial")
@Entity
public class Post implements Serializable {
	
	@EmbeddedId
	private PostId postId;
	@Column
	private String postSj; // 제목
	@Column
	private String postCn; // 내용
	@Column
	private String regstrId; // 작성자 ID
	@Column
	private Date regDt; // 작성일
	
};