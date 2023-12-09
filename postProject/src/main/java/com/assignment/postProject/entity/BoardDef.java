package com.assignment.postProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// 게시판 분류 정보
@Entity
public class BoardDef {
	
	@Id
	private String boardCd; // 게시판 분류 코드
	@Column
	private String boardNm; // 게시판 분류 이름
	
};
