package com.assignment.postProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.postProject.dto.PostDto;
import com.assignment.postProject.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// 게시판에 따른 게시글 목록 페이지 호출
	@GetMapping("/post")
	public String postList(Model model, @RequestParam String boardCd) {
		log.info("PostController - postList()");
		log.info("boardCd: {}", boardCd);
		
		// 게시글 목록 가져오기
//		List<PostDto> postList = postService.findPostList(boardCd);
//		
//		model.addAttribute("postList", postList);
		
		return "post";
	};
	
};
