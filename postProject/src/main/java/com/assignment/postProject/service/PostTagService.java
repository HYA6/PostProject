package com.assignment.postProject.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.postProject.dto.PostDto;
import com.assignment.postProject.dto.PostTagDto;
import com.assignment.postProject.entity.BoardDef;
import com.assignment.postProject.entity.Post;
import com.assignment.postProject.entity.PostTag;
import com.assignment.postProject.entity.Tag;
import com.assignment.postProject.repository.BoardRepository;
import com.assignment.postProject.repository.PostRepository;
import com.assignment.postProject.repository.PostTagRepository;
import com.assignment.postProject.repository.TagRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostTagService {
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private PostTagRepository postTagRepository;
	
	// 게시물 태그 저장
	@Transactional
	public void savePostTag(PostDto postDto, String[] tagStr) {
		log.info("PostTagService - savePostTag()");
		// 게시판 정보 가져오기
		BoardDef def = boardRepository.findById(postDto.getBoardCd())
				.orElseThrow(() -> new IllegalArgumentException("게시물 태그 저장 실패! 대상 게시판이 없습니다."));
		// 게시글 글번호 불러오기
		int postId = postRepository.findIdByCdAndSj(postDto.getBoardCd(), postDto.getPostSj());
		// 게시물 정보 가져오기
		Post post = postRepository.findById(Long.valueOf(postId))
				.orElseThrow(() -> new IllegalArgumentException("게시물 태그 저장 실패! 대상 게시물이 없습니다."));
				
		for(String tagSt: tagStr) {
			// 태그 ID 불러오기
			int tagId = tagRepository.findIdByTagAndCd(tagSt, postDto.getBoardCd());
			Tag tag = tagRepository.findById(Long.valueOf(tagId))
					.orElseThrow(() -> new IllegalArgumentException("게시물 태그 저장 실패! 대상 게시물이 없습니다."));
			PostTagDto postTagDto = new PostTagDto();
			postTagDto.setBoardCd(postDto.getBoardCd());
			postTagDto.setPostNo(postId);
			postTagDto.setTagNo(tagId);
			postTagRepository.save(PostTag.toEntity(postTagDto, post, def, tag));
		};

	}
	
	// 태그 ID 찾기
	public List<PostTagDto> findByPostNo(String postNo) {
		log.info("PostTagService - findByPostNo()");
		return postTagRepository.findByPostNo(postNo)
				.stream()
				.map(postTags -> PostTagDto.toDto(postTags)) // entity를 dto로 변환
				.collect(Collectors.toList());
	};

};
