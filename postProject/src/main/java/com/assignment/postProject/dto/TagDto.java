package com.assignment.postProject.dto;

import com.assignment.postProject.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 태그 dto
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TagDto {
	
	private long tagNo; // 태그 ID
	private String tag; // 태그
	private String boardCd; // 게시판 분류 코드
	
	// entity -> dto
	public static TagDto toDto(Tag tag) {
		return new TagDto(tag.getTagNo(), tag.getTag(), tag.getBoardDef().getBoardCd());
	};
	
};
