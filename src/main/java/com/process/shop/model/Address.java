package com.process.shop.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String avenue;
    private String postalCode;
    private String neighborhood;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;
}
