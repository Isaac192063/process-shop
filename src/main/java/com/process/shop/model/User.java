package com.process.shop.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "please provide a full name")
    @Size(min = 10, max = 200)
    private String fullName;

    private LocalDate fullBirthDay;

    @NotNull(message = "please provide a document type")
    private String identificationType;

    @NotNull(message = "please provide the document")
    @Size(max = 10, min = 5)
    private String document;

    private String phoneNumber;

    @NotBlank(message = "please provide the email")
    @NotNull(message = "please provide the email")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotNull(message = "please provide the password")
    @Size(min = 8,max = 15)
    private String password;

    @Valid
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
