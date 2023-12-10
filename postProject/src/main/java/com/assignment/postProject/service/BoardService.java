package com.assignment.postProject.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.postProject.dto.BoardDefDto;
import com.assignment.postProject.entity.BoardDef;
import com.assignment.postProject.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 게시판 목록 찾기
	public List<BoardDefDto> findBoardList() {
		log.info("BoardService - findBoardList()");
		return boardRepository.findAll()
				.stream()
				.map(boards -> BoardDefDto.toDto(boards)) // entity를 dto로 변환
				.collect(Collectors.toList());
	};
	
	// 하나의 게시판 정보 찾기
	public BoardDefDto findBoard(String boardCd) {
		log.info("BoardService - findBoard()");
		BoardDef def = boardRepository.findById(boardCd)
				.orElseThrow(() -> new IllegalArgumentException("게시판 조회 실패! 대상 게시판이 없습니다."));
		return BoardDefDto.toDto(def);
	};
	
	// 게시판 저장
	@Transactional
	public void saveBoard(BoardDefDto boardDefDto) {
		log.info("BoardService - saveBoard()");
		boardRepository.save(BoardDef.toEntity(boardDefDto));
	}
	
	// 게시판 삭제
	@Transactional
	public void deleteBoard(String boardCd) {
		log.info("BoardService - deleteBoard()");
		boardRepository.deleteById(boardCd);
	};

};
