package com.assignment.postProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

// 게시판 분류 정보
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class BoardDef {
	
	private String boardCd; // 게시판 분류 코드
	private String boardNm; // 게시판 분류 이름
	
};
