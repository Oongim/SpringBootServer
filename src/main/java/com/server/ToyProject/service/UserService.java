package com.server.ToyProject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.server.ToyProject.dto.User.LoginUserDto;
import com.server.ToyProject.entity.Authority;
import com.server.ToyProject.entity.User;
import com.server.ToyProject.repository.UserRepository;
import com.server.ToyProject.util.SecurityUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(String name, String email){
        User n = new User(name,email);
        userRepository.save(n);

    }

    @Transactional  // Entity는 Transaction이 종료되면 변경된 필드를 자동으로 감지하여 db에 commit을 해줍니다. 이와 같은 개념이 Dirty Checking 입니다. //https://jessyt.tistory.com/35
    public LoginUserDto loginUser(LoginUserDto dto){
       User user = userRepository.findOneWithAuthoritiesByEmail(dto.getEmail()).orElse(null);
        if ( user == null) {

            Authority authority = Authority.builder()
            .authorityName("ROLE_USER")
            .build();

            user = User.builder()
            .email(dto.getEmail())
            .uuid(passwordEncoder.encode(dto.getUuid()))
            .name(dto.getName())
            .activated(true)
            .authorities(Collections.singleton(authority))
            .build();
          
        }
        Date now = new Date();
        user.setLastLoginAt(now);

        return LoginUserDto.from(userRepository.save(user));
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public LoginUserDto getUserWithAuthorities(String email) {
        System.out.println("pass LoginUserDto");
        return LoginUserDto.from(userRepository.findOneWithAuthoritiesByEmail(email).orElse(null));
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public User getMyUserWithAuthorities() {
        
        User user = SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByEmail).orElse(null);
        System.out.println("pass User: "+ user);
        return user;
    }
}
