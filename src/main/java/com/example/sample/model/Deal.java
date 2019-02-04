package com.example.sample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name="deal")
@Getter @Setter
public class Deal extends BaseModel {

    private String type;
    private long size;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private Company parentCompany;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private Company targetCompany;
}
