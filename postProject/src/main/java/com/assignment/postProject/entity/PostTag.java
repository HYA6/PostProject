package com.assignment.postProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.assignment.postProject.dto.PostTagDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 게시물 태그
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostTag {
	
	@Id
	@Column(columnDefinition="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boardTagId; // 게시물 태그 ID
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="post_no", referencedColumnName="postNo")
	private Post post; // 글번호
	
	@ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "board_cd", referencedColumnName="boardCd")
    private BoardDef boardDef; // 게시판 정보
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="tag_no", referencedColumnName="tagNo")
	private Tag tag; // 태그 ID
	
	// dto -> entity
	public static PostTag toEntity(PostTagDto dto, Post post, BoardDef boardDef, Tag tag) {
		return new PostTag(dto.getBoardTagId(), post, boardDef, tag);
	};
	
};
