package com.assignment.postProject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.postProject.dto.PostDto;
import com.assignment.postProject.dto.PostIdDto;
import com.assignment.postProject.entity.BoardDef;
import com.assignment.postProject.entity.PostId;
import com.assignment.postProject.repository.BoardRepository;
import com.assignment.postProject.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostService {
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private PostRepository postRepository;
	
	// 게시판에 따른 게시글 전체 목록 가져오기
	public List<PostDto> findPostList(String boardCd) {
		log.info("PostService - findBoardList()");
		
		// 게시판 정보 가져오기
		BoardDef def = boardRepository.findById(boardCd)
				.orElseThrow(() -> new IllegalArgumentException("게시글 불러오기 실패! 대상 게시판이 없습니다."));
		
		// postId에 boardCd 저장
		PostIdDto id = new PostIdDto();
		id.setBoardCd(boardCd);
		
		return postRepository.findById(PostId.toEntity(id, def))
				.stream()
				.map(posts -> PostDto.toDto(posts))
				.collect(Collectors.toList());
	};

};
