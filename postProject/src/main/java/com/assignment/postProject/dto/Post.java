package com.assignment.postProject.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

// 게시물 dto
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class Post {
	
	private long postNo; // 글번호
	private String postSj; // 제목
	private String postCn; // 내용
	private String regstrId; // 작성자 ID
	private Date regDt; // 작성일
	
};
