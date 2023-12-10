package com.assignment.postProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.postProject.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
	
	@Query(value = "SELECT COUNT(*) FROM Tag WHERE board_cd = :board_cd AND tag = :tag", nativeQuery=true)
	int findByTagAndCd(String tag, String board_cd);


	@Query(value = "SELECT tag_no FROM Tag WHERE board_cd = :board_cd AND tag = :tag", nativeQuery=true)
	int findIdByTagAndCd(String tag, String board_cd);
	

};
