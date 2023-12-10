package com.assignment.postProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.assignment.postProject.entity.PostTag;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
	
	@Query(value = "SELECT * FROM Post_Tag WHERE post_no = :post_no", nativeQuery=true)
	List<PostTag> findByPostNo(String post_no);
	
	@Query(value = "SELECT COUNT(*) FROM Post_Tag WHERE board_cd = :board_cd "
			+ "AND tag_no = :tag_no AND post_no = :post_no", nativeQuery=true)
	int findByTagAndCd(int tag_no, int post_no, String board_cd);
	
	@Modifying
	@Query(value = "DELETE FROM Post_Tag WHERE tag_no = :tag_no AND post_no = :post_no", nativeQuery=true)
	void deleteByTagAndPost(int tag_no, int post_no);
	
};
