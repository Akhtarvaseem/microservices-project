package com.micro.userservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.userservice.entity.User;
import com.micro.userservice.entity.Rating;


public interface UserRepository extends JpaRepository<User, Integer>{

	 
}
