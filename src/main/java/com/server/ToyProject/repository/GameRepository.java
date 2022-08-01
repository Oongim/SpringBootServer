package com.server.ToyProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.server.ToyProject.entity.Game;

public interface GameRepository extends CrudRepository<Game,Integer>{
    
}
