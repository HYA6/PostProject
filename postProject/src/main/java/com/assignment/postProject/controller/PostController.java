package com.assignment.postProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {
	
	@GetMapping("/post")
	public String postList() {
		log.info("PostController의 postList()");
		
		return "main";
	};
	
};
