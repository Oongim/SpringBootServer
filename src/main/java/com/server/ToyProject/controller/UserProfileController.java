package com.server.ToyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.ToyProject.dto.UserProfile.CreateProfileDto;
import com.server.ToyProject.service.UserProfileService;

@Controller
@RequestMapping(path = "/userProfile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping()
    public @ResponseBody String createProfile(@RequestBody CreateProfileDto dto){
        //userProfileService
        
        return "ok";
    }
}
