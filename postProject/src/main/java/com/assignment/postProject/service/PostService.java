package com.assignment.postProject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.postProject.dto.PostDto;
import com.assignment.postProject.dto.PostIdDto;
import com.assignment.postProject.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	// 게시판에 따른 게시글 전체 목록 가져오기
//	public List<PostDto> findPostList(String boardCd) {
//		log.info("PostService - findBoardList()");
//		
//		return postRepository.findById(boardCd)
//				.stream()
//				.map(posts -> PostDto.toDto(posts)) // entity를 dto로 변환
//				.collect(Collectors.toList());
//	};

};
