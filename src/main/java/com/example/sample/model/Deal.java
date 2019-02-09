package com.example.sample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

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

    @JoinTable(name = "deal_user_role",
            joinColumns = @JoinColumn(name = "deal_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @MapKeyJoinColumn(name = "user_id")
    @ElementCollection
    private Map<Role, User> userRolesMap = new HashMap<>();
}
