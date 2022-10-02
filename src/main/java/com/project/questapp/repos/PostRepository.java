package com.project.questapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entites.Post;


public interface PostRepository extends JpaRepository<Post,Long> {

	List<Post> findByUserId(Long userId);

}
