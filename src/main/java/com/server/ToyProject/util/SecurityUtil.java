package com.server.ToyProject.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.server.ToyProject.entity.User;

import java.util.Optional;

public class SecurityUtil {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);
 
    private SecurityUtil() {
    }
 
    public static Optional<String> getCurrentUsername() {
       final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       System.out.println("getCurrentUsername: "+authentication);
       if (authentication == null) {
          logger.debug("Security Context에 인증 정보가 없습니다.");
          return Optional.empty();
       }
 
       String username = null;
       if (authentication.getPrincipal() instanceof User) {
        User springSecurityUser = (User) authentication.getPrincipal();
        System.out.println("springSecurityUser: "+springSecurityUser);
          username = springSecurityUser.getUuid();
          System.out.println("username: "+username);
       } else if (authentication.getPrincipal() instanceof String) {
          username = (String) authentication.getPrincipal();
       }
       
       return Optional.ofNullable(username);
    }
 }
