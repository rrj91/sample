package com.example.sample.dto;

import com.example.sample.model.Company;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DealDTO extends BaseDTO {
    private String type;
    private long size;
    private Company parentCompany;
    private Company targetCompany;

}
