package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entites.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.response.PostResponse;
import com.project.questapp.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	@GetMapping
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}
	
	@GetMapping("/{postId}")
	public Post  getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}
	
	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable Long postId,@RequestBody PostUpdateRequest update) {
		return postService.updateOnePostById(postId,update);
	}
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		postService.deleteOnePostById(postId);
	}
	
}
