package com.project.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.questapp.entites.Comment;
import com.project.questapp.entites.Post;
import com.project.questapp.entites.User;
import com.project.questapp.repos.CommentRepository;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;

@Service
public class CommentService {
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;
	@Autowired
	public CommentService(CommentRepository commentRepository,UserService userService,PostService postService) {
		this.commentRepository = commentRepository;
		this.postService= postService;
		this.userService =userService;
	}

	public List<Comment> getAllCommentWtihParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		}else
			return commentRepository.findAll();
	}

	public Comment getOneCommentById(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user!= null && post !=null) {
			Comment comment = new Comment();
			comment.setId(request.getId());
			comment.setPost(post);
			comment.setUser(user);
			comment.setText(request.getText());
			return commentRepository.save(comment);
		}else
			return null;
	}

	public Comment updateOneCommentById(Long commentId,CommentUpdateRequest request) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if (comment.isPresent()) {
			Comment commentUpdate = comment.get();
			commentUpdate.setText(request.getText());
			return commentRepository.save(commentUpdate);
		}else
			return null;
	}

	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}
	
}
