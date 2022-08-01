package com.server.ToyProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.server.ToyProject.entity.Card;

public interface CardRepository extends CrudRepository<Card,Integer>{
    
}

