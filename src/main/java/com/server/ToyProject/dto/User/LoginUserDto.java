package com.server.ToyProject.dto.User;

import com.server.ToyProject.entity.User;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    private String uuid;
    private String email;
    private String name;

    public static LoginUserDto from(User user) {
        if(user == null) return null;
  
        return LoginUserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
     }
}
