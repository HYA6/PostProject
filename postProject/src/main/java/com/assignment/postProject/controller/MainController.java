package com.assignment.postProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@GetMapping("/")
	public String start() {
		log.info("웹 페이지 시작");
		return "main";
	};
	
};
