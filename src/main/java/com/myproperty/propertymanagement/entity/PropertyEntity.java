package com.myproperty.propertymanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="PROPERTY_NAME", nullable = false)
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;
}
