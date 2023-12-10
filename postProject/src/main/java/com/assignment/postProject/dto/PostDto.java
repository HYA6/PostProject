package com.assignment.postProject.dto;

import java.util.Date;

import com.assignment.postProject.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 게시물 dto
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private long postNo; // 글번호
	private String boardCd; // 게시판 분류 코드
	private String postSj; // 제목
	private String postCn; // 내용
	private String regstrId; // 작성자 ID
	private Date regDt; // 작성일
	
	// entity -> dto
	public static PostDto toDto(Post post) {
		return new PostDto(post.getPostId().getPostNo(), post.getPostId().getBoardDef().getBoardCd(), 
				post.getPostSj(), post.getPostCn(), post.getRegstrId(), post.getRegDt());
	};
	
};
