package com.assignment.postProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.assignment.postProject.dto.BoardDefDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 게시판 분류 정보
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardDef{
	
	@Id
	private String boardCd; // 게시판 분류 코드
	@Column
	private String boardNm; // 게시판 분류 이름
	
	// dto -> entity
	public static BoardDef toEntity(BoardDefDto dto) {
		return new BoardDef(dto.getBoardCd(), dto.getBoardNm());
	};
	
};
