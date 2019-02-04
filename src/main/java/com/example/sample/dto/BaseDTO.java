package com.example.sample.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class BaseDTO {

    private Long id;
    private String name;
    private String description;
    private String createdTimestamp;
    private String modifiedTimestamp;
}
