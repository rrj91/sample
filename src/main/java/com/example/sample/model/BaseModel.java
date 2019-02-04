package com.example.sample.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor
public abstract class BaseModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "created_timestamp")
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createdTimestamp;

    @Column(name = "modified_timestamp")
    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date modifiedTimestamp;

}
