package com.assignment.postProject.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.assignment.postProject.dto.PostDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 게시물
@SuppressWarnings("serial")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Post implements Serializable {
	
	@EmbeddedId
	private PostId postId; // 글번호, 게시판 분류 코드
	@Column
	private String postSj; // 제목
	@Column
	private String postCn; // 내용
	@Column
	private String regstrId; // 작성자 ID
	@Column
	private Date regDt; // 작성일
	
	// dto -> entity
	public static Post toEntity(PostDto dto, PostId postId) {
		return new Post(postId, dto.getPostSj(), dto.getPostCn(), dto.getRegstrId(), dto.getRegDt());
	};
	
};