package com.assignment.postProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

// 게시물 태그 dto
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class PostTag {
	
	private long boardTagId; // 게시물 태그 ID
	private long postNo; // 글번호
	private String boardCd; // 게시판 분류 코드
	private long tagNo; // 태그 ID
	
};
