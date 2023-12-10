package com.assignment.postProject.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.postProject.dto.BoardDefDto;
import com.assignment.postProject.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 게시판 목록 페이지 호출
	@GetMapping("/")
	public String boardList(Model model) {
		log.info("BoardController - boardList()");
		
		// 게시판 목록 가져오기
		List<BoardDefDto> boardList = boardService.findBoardList();
		
		model.addAttribute("boardList", boardList);
		
		return "board";
	};
	
	// 게시판 생성하기
	@PostMapping("/boardCreate")
	public String boardCreate(BoardDefDto boardDefDto) {
		log.info("BoardController - boardCreate()");
		
		// 게시판 분류 코드(난수) 생성
		Random random = new Random();
		boardDefDto.setBoardCd(Integer.toString(random.nextInt(100000)));
		
		// 게시판 생성
		boardService.saveBoard(boardDefDto);
		
		return "redirect:";
	};
	
};
