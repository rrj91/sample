package com.example.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="company")
@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company extends BaseModel {

    private String industry;
    private String type;
    private double revenue;
    @OneToMany
    List<Company> deals;
}
