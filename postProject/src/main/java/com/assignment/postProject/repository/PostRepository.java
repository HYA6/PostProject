package com.assignment.postProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.postProject.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query(value = "SELECT * FROM Post WHERE board_cd = :board_cd ORDER BY post_no DESC", nativeQuery=true)
	List<Post> findByBoardCd(String board_cd);

	@Query(value = "SELECT post_no FROM Post WHERE board_cd = :board_cd "
			+ "AND post_sj = :post_sj", nativeQuery=true)
	int findIdByCdAndSj(String board_cd, String post_sj);

};
