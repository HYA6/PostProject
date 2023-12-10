package com.assignment.postProject.dto;

import com.assignment.postProject.entity.PostId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 게시물 dto
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostIdDto {
	
	private long postNo; // 글번호
	private String boardCd; // 게시판 분류 코드
	
	// entity -> dto
	public static PostIdDto toDto(PostId postId) {
		return new PostIdDto(postId.getPostNo(), postId.getBoardDef().getBoardCd());
	};
	
};
