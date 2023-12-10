package com.assignment.postProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.postProject.entity.PostTag;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
	
	@Query(value = "SELECT * FROM Post_Tag WHERE post_no = :post_no", nativeQuery=true)
	List<PostTag> findByPostNo(String post_no);

};
