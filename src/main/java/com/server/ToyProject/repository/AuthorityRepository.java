package com.server.ToyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.ToyProject.entity.Authority;

public interface AuthorityRepository  extends JpaRepository<Authority, String> {
    
}
