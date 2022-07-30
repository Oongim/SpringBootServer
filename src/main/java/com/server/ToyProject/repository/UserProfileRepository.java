package com.server.ToyProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.server.ToyProject.entity.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile,Integer>{
    
}
