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

import com.assignment.postProject.dto.TagDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 태그
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Tag {
	
	@Id
	@Column(columnDefinition="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagNo; // 태그 ID
	@Column
	private String tag; // 태그
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "board_cd", referencedColumnName="boardCd")
	private BoardDef boardDef; // 게시판 분류 코드
	
	// dto -> entity
	public static Tag toEntity(TagDto dto, BoardDef boardDef) {
		return new Tag(dto.getTagNo(), dto.getTag(), boardDef);
	};
	
};
