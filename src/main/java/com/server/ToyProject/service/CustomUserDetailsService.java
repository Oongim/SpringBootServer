package com.server.ToyProject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.server.ToyProject.entity.User;
import com.server.ToyProject.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        org.springframework.security.core.userdetails.User result = userRepository.findOneWithAuthoritiesByEmail(username)
        .map(user ->{ 
            return createUser(username, user);})
        .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
        System.out.println("result "+result);
       return result;
    }
 
    private org.springframework.security.core.userdetails.User createUser(String username, User user) {
        System.out.println("user.isActivated(): "+user.isActivated());
       if (!user.isActivated()) {
          throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
       }
       List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
               .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
               .collect(Collectors.toList());
       return new org.springframework.security.core.userdetails.User(user.getEmail(),
               user.getUuid(),
               grantedAuthorities);
    }
    
}
