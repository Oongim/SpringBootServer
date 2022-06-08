package com.server.ToyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.ToyProject.dto.Item.AddItemDto;
import com.server.ToyProject.entity.Item;
import com.server.ToyProject.service.ItemService;

@Controller
@RequestMapping(path="item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping()
    public @ResponseBody String addNewItem(@RequestBody AddItemDto dto){
        itemService.createItem(dto);
        return "ok";
    }

    @GetMapping("/{type}")
    public @ResponseBody Iterable<Item> getItemByType(@PathVariable String type){
        return itemService.getItemsByType(type);
    }
}
