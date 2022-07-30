package com.server.ToyProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.server.ToyProject.entity.UserGoods;

public interface UserGoodsRepository extends CrudRepository<UserGoods,Integer>{
    
}
