package com.server.ToyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.ToyProject.dto.Game.CreateGameDto;
import com.server.ToyProject.service.GameService;

@RestController
@RequestMapping(path = "/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping()
    public @ResponseBody String createGame(@RequestBody CreateGameDto dto  ){
        gameService.notify();
        return "ok";
    }
    
}
