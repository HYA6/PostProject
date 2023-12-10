package com.assignment.postProject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.assignment.postProject.dto.PostIdDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 게시물 기본키 클래스
@SuppressWarnings("serial")
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class PostId implements Serializable {
	
	@Column(columnDefinition="int")
	private long postNo; // 글번호
	
    @ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "board_cd", referencedColumnName="boardCd")
	private BoardDef boardDef; // 게시판 정보
    
    // dto -> entity
 	public static PostId toEntity(PostIdDto dto, BoardDef boardDef) {
 		return new PostId(dto.getPostNo(), boardDef);
 	};

};
