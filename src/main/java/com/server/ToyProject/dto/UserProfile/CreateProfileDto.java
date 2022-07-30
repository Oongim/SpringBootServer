package com.server.ToyProject.dto.UserProfile;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateProfileDto {
    private String uuid;
    private String name;
}
