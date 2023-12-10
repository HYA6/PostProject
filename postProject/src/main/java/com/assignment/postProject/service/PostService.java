package com.assignment.postProject.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.postProject.dto.PostDto;
import com.assignment.postProject.entity.BoardDef;
import com.assignment.postProject.entity.Post;
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
		
		// 게시판 여부 확인
		boardRepository.findById(boardCd)
				.orElseThrow(() -> new IllegalArgumentException("게시글 조회 실패! 대상 게시판이 없습니다."));
		
		return postRepository.findByBoardCd(boardCd)
				.stream()
				.map(posts -> PostDto.toDto(posts))
				.collect(Collectors.toList());
	};
	
	// 게시글 한 건 찾기
	public PostDto findPost(long postNo) {
		log.info("PostService - findPost()");
		return PostDto.toDto(
				postRepository.findById(postNo)
				.orElseThrow(() -> new IllegalArgumentException("게시글 조회 실패! 대상 게시글이 없습니다.")));
	};
	
	// 게시글 저장 및 수정
	@Transactional
	public void savePost(PostDto postDto) {
		log.info("PostService - savePost()");
		
		// 게시판 정보 가져오기
		BoardDef def = boardRepository.findById(postDto.getBoardCd())
				.orElseThrow(() -> new IllegalArgumentException("게시글 저장 실패! 대상 게시판이 없습니다."));
		
		// entity로 변환
		Post post = Post.toEntity(postDto, def);
//		log.info("post: {}", post.getPostNo());
		
		// 게시글 저장 및 수정
		postRepository.save(post);
	};
	
	// 게시글 삭제
	@Transactional
	public void deletePost(long postNo) {
		log.info("PostService - deletePost()");
		postRepository.deleteById(postNo);
	};

};
