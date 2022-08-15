package com.server.ToyProject.controller;

import com.server.ToyProject.dto.User.LoginUserDto;
import com.server.ToyProject.entity.User;
import com.server.ToyProject.repository.UserRepository;
import com.server.ToyProject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping(path = "/user") // url 경로가 demo로 시작한다
public class UserController {
    @Autowired
    private UserService userService;

    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    @PostMapping() // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        userService.createUser(name,email);
        return "Saved";
    }

    @PostMapping(path = "/google/login")
    public @ResponseBody LoginUserDto LoginUser(@RequestBody LoginUserDto dto) {
   
        return userService.loginUser(dto);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public @ResponseBody User getMyUserInfo() {
        return userService.getMyUserWithAuthorities();
    }
}
