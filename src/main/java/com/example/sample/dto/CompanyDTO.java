package com.example.sample.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CompanyDTO extends BaseDTO{

    private String industry;
    private String type;
    private double revenue;

}
