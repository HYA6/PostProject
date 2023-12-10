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
import com.assignment.postProject.dto.PostTagDto;
import com.assignment.postProject.dto.TagDto;
import com.assignment.postProject.service.BoardService;
import com.assignment.postProject.service.PostService;
import com.assignment.postProject.service.PostTagService;
import com.assignment.postProject.service.TagService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PostController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private PostService postService;
	@Autowired
	private TagService tagService;
	@Autowired
	private PostTagService postTagService;
	
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
	
	// 게시글 한 건 보는 페이지 호출
	@GetMapping("/singlePost")
	public String singlePost(Model model, @RequestParam String postNo) {
		log.info("PostController - singlePost()");
		// 게시글 정보 찾기
		PostDto postDto = postService.findPost(Long.parseLong(postNo));
		// 태그 ID 찾기
		List<PostTagDto> postTagDto = postTagService.findByPostNo(postNo);
		// 태그 정보 찾기
		List<TagDto> tagDto = tagService.findTag(postTagDto);
		
		model.addAttribute("postDto", postDto);
		model.addAttribute("tagDto", tagDto);
		
		return "post/singlePost";
	};
	
	// 게시글 작성 페이지 호출
	@PostMapping("/createPost")
	public String createPost(Model model, String boardCd) {
		log.info("PostController - createPost()");
		model.addAttribute("boardCd", boardCd);
		return "post/createPost";
	};
	
	// 게시글, 태그 저장
	@PostMapping("/insertPost")
	public String insertPost(Model model, PostDto postDto, TagDto tagDto, RedirectAttributes re) {
		log.info("PostController - insertPost()");
		
		// 작성일에 현재 날짜 저장
		Date date = new Date();
		postDto.setRegDt(date);
		// 게시글 저장
		postService.savePost(postDto);
		
		// 각각의 태그 분리
		String[] tagStr = tagDto.getTag().split(",");
		
		// 태그 저장
		tagService.saveTag(tagDto, tagStr);
		
		// 게시물 태그 저장
		postTagService.savePostTag(postDto, tagStr);
		
		re.addAttribute("boardCd", postDto.getBoardCd());
		
		return "redirect:post";
	};
	
	// 게시글 수정하기
	@PostMapping("/updatePost")
	public String updatePost(PostDto postDto, RedirectAttributes re) {
		log.info("BoardController - updatePost()");
		// 게시판 수정
		postService.savePost(postDto);
		re.addAttribute("postNo", postDto.getPostNo());
		return "redirect:singlePost";
	};

	// 게시글 삭제하기
	@GetMapping("/deletePost")
	public String deleteBoard(@RequestParam String postNo, @RequestParam String boardCd, RedirectAttributes re) {
		log.info("BoardController - deleteBoard()");
		// 게시판 삭제
		postService.deletePost(Long.parseLong(postNo));
		re.addAttribute("boardCd", boardCd);
		return "redirect:post";
	};
	
};
