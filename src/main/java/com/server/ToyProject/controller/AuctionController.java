package com.server.ToyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.ToyProject.entity.Item;
import com.server.ToyProject.service.AuctionService;

@Controller
@RequestMapping(path = "/auction")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

    // @GetMapping
    // public @ResponseBody Iterable<Item> searchAuction(){
    //     Iterable<Item> items=new Iterable<Item>
    //     return items
    // }
}
