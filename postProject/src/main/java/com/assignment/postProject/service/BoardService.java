package com.assignment.postProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.postProject.dto.BoardDefDto;
import com.assignment.postProject.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 게시판 목록 찾기
	@Transactional
	public List<BoardDefDto> findBoardList() {
		log.info("BoardService - findBoardList()");
		
		boardRepository.findAll();
		log.info("{}", boardRepository.findAll());
		
		return null;
	};

};
