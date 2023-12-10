package com.assignment.postProject.dto;

import com.assignment.postProject.entity.BoardDef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 게시판 분류 정보
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardDefDto {
	
	private String boardCd; // 게시판 분류 코드
	private String boardNm; // 게시판 분류 이름
	
	// entity -> dto
	public static BoardDefDto toDto(BoardDef def) {
		return new BoardDefDto(def.getBoardCd(), def.getBoardNm());
	};
	
};
