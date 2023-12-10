package com.assignment.postProject.dto;

import com.assignment.postProject.entity.PostTag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 게시물 태그 dto
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostTagDto {
	
	private long boardTagId; // 게시물 태그 ID
	private long postNo; // 글번호
	private String boardCd; // 게시판 분류 코드
	private long tagNo; // 태그 ID
	
	// entity -> dto
	public static PostTagDto toDto(PostTag postTag) {
		return new PostTagDto(postTag.getBoardTagId(), postTag.getPost().getPostNo(), 
				postTag.getBoardDef().getBoardCd(), postTag.getTag().getTagNo());
	};
	
};
