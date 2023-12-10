package com.assignment.postProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assignment.postProject.service.PostTagService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostTagController {
	
	@Autowired
	private PostTagService postTagService;
	
	// 게시글 태그 삭제하기
	@GetMapping("/deletePostTag")
	public String deletePostTag(@RequestParam String tagNo, @RequestParam String postNo, RedirectAttributes re) {
		log.info("PostTagController - deletePostTag()");
		// 게시글 태그 삭제
		postTagService.deletePostTag(Integer.parseInt(tagNo), Integer.parseInt(postNo));
		re.addAttribute("postNo", postNo);
		return "redirect:updatePost";
	};
	
};
