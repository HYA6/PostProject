package com.assignment.postProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.assignment.postProject.dto.BoardDefDto;
import com.assignment.postProject.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String postList(Model model) {
		log.info("PostController의 postList()");
		
		// 게시판 목록 가져오기
		List<BoardDefDto> boardList = boardService.findBoardList();
		
		model.addAttribute("boardList", boardList);
		
		return "main";
	};
	
};
