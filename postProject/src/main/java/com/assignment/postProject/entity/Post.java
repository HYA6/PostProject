package com.assignment.postProject.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.assignment.postProject.dto.PostDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 게시물
@SuppressWarnings("serial")
@EntityListeners(AuditingEntityListener.class)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post implements Serializable {
	
	@Id
    @Column(columnDefinition="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postNo; // 글번호
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "board_cd", referencedColumnName="boardCd")
    private BoardDef boardDef; // 게시판 정보
	@Column
	private String postSj; // 제목
	@Column
	private String postCn; // 내용
	@Column
	private String regstrId; // 작성자 ID
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp regDt; // 작성일
	
	// dto -> entity
    public static Post toEntity(PostDto dto, BoardDef boardDef) {
        return new Post(dto.getPostNo(), boardDef, dto.getPostSj(), dto.getPostCn(), dto.getRegstrId(), dto.getRegDt());
    };
	
};