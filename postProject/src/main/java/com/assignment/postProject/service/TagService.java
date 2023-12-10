package com.assignment.postProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.postProject.dto.TagDto;
import com.assignment.postProject.entity.BoardDef;
import com.assignment.postProject.entity.Tag;
import com.assignment.postProject.repository.BoardRepository;
import com.assignment.postProject.repository.TagRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TagService {
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private TagRepository tagRepository;
	
	// 태그 저장
	@Transactional
	public void saveTag(TagDto tagDto, String[] tagStr) {
		log.info("TagService - saveTag()");
		// 게시판 정보 가져오기
		BoardDef def = boardRepository.findById(tagDto.getBoardCd())
				.orElseThrow(() -> new IllegalArgumentException("태그 저장 실패! 대상 게시판이 없습니다."));
		// 태그 저장
		List<Tag> tagList = new ArrayList<Tag>();
		for(String tag : tagStr) {
			// 있는 태그인지 확인
			int tagCount = tagRepository.findByTagAndCd(tag, tagDto.getBoardCd());
			// 없는 태그면 리스트에 태그 entity 추가
			if (tagCount == 0) {
				// dto에 분리된 태그 저장
				tagDto.setTag(tag);
				tagList.add(Tag.toEntity(tagDto, def));
			};
		};
		tagRepository.saveAll(tagList);
	};

};
