package com.process.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "please provide the avenue")
    private String avenue;

    private String postalCode;

    @NotNull(message = "please provide the neighborhood")
    @Size(max = 50, min = 4)
    private String neighborhood;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;
}
