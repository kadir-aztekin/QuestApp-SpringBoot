package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entites.User;

public interface UserRepository  extends JpaRepository<User,Long>{

	User findbyUserName(String username);

}
