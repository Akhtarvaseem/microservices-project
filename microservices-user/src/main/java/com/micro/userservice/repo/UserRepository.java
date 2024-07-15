package com.micro.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
