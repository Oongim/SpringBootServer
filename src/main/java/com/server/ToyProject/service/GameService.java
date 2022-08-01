package com.server.ToyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.ToyProject.repository.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
}
