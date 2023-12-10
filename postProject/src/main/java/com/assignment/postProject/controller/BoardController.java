package com.assignment.postProject.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@PostMapping("/insertBoard")
	public String insertBoard(BoardDefDto boardDefDto) {
		log.info("BoardController - insertBoard()");
		
		// 게시판 분류 코드(난수) 생성
		Random random = new Random();
		boardDefDto.setBoardCd(Integer.toString(random.nextInt(100000)));
		
		// 게시판 생성
		boardService.saveBoard(boardDefDto);
		
		return "redirect:";
	};
	
	// 게시판 삭제하기
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam String boardCd) {
		log.info("BoardController - deleteBoard()");
		// 게시판 삭제
		boardService.deleteBoard(boardCd);
		return "redirect:";
	};
	
};
