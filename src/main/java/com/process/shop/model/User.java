package com.process.shop.model;

import com.process.shop.model.enums.DocumentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private LocalDate fullBirthDay;
    private DocumentType identificationType;
    private String document;
    private String phoneNumber;
    private String email;
    private String password;
  //  private List<Address> address;
}
