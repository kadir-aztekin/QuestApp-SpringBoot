package com.project.questapp.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PostCreateRequest {
	@JsonIgnore
	Long id;
	String text;
	String title;
	Long userId;
}
