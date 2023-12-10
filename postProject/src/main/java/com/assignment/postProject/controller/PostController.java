package com.assignment.postProject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assignment.postProject.dto.BoardDefDto;
import com.assignment.postProject.dto.PostDto;
import com.assignment.postProject.service.BoardService;
import com.assignment.postProject.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private PostService postService;
	
	// 게시판에 따른 게시글 목록 페이지 호출
	@GetMapping("/post")
	public String postList(Model model, @RequestParam String boardCd) {
		log.info("PostController - postList()");
		
		// 게시판 정보 가져오기
		BoardDefDto defDto = boardService.findBoard(boardCd);
		
		// 게시글 목록 가져오기
		List<PostDto> postList = postService.findPostList(boardCd);
		
		model.addAttribute("postList", postList);
		model.addAttribute("boardCd", boardCd);
		model.addAttribute("boardNm", defDto.getBoardNm());
		
		return "post/post";
	};
	
	// 게시글 작성 페이지 호출
	@PostMapping("/createPost")
	public String createPost(Model model, String boardCd) {
		log.info("PostController - createPost()");
		model.addAttribute("boardCd", boardCd);
		return "post/createPost";
	};
	
	// 게시글 저장
	@PostMapping("/insertPost")
	public String insertPost(Model model, PostDto postDto, RedirectAttributes re) {
		log.info("PostController - insertPost()");
		
		// 작성일에 현재 날짜 저장
		Date date = new Date();
		postDto.setRegDt(date);
		
		postService.savePost(postDto);
		
		re.addAttribute("boardCd", postDto.getBoardCd());
		
		return "redirect:post";
	};
	
};
