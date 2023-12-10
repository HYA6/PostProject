package com.assignment.postProject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.assignment.postProject.dto.BoardDefDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 게시판 분류 정보
@SuppressWarnings("serial")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class BoardDef implements Serializable {
	
	@Id
	private String boardCd; // 게시판 분류 코드
	@Column
	private String boardNm; // 게시판 분류 이름
	
	// dto -> entity
	public static BoardDef toEntity(BoardDefDto dto) {
		return new BoardDef(dto.getBoardCd(), dto.getBoardNm());
	};
	
};
