package com.example.sample.dto;

import com.example.sample.model.Company;
import com.example.sample.model.Role;
import com.example.sample.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DealDTO extends BaseDTO {
    private String type;
    private long size;
    private Company parentCompany;
    private Company targetCompany;
    private Role role;
    private User user;
}
