package com.server.ToyProject.dto.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginUserDto {
    private String uuid;
    private String email;
}
