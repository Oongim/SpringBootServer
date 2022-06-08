package com.server.ToyProject.dto.Item;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddItemDto {
    private String type;
    private String stats;
    private Integer userId;
}
