package com.server.ToyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.ToyProject.dto.Item.AddItemDto;
import com.server.ToyProject.entity.Item;
import com.server.ToyProject.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(AddItemDto dto){
        Item item = new Item(dto.getType(),dto.getStats());
        item.setUser_id(dto.getUserId());
        return itemRepository.save(item);
    }
    
    public Iterable<Item> getItemsByType(String type){
        return itemRepository.findByType(type);
    }
}
