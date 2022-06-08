package com.server.ToyProject.repository;

import com.server.ToyProject.entity.Item;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Integer>{
    public List<Item> findByType(String type);
}
