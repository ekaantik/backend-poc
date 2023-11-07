package com.poc.ecard.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_creds")
public class User implements UserDetails { // extends BaseUuidEntity
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="mobile_num", unique = true)
    private String mobileNum;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="city")
    private String city;

    @Column(name="qr_code_image_path")
    private String qr_code_image_path;

    @Column(name="byte_code")
    private byte[] byte_code;

    @Column(name="profile_img")
    private String profile_img;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserContactBook> contactList;
//    private String password; // otp in our case

    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return mobileNum;
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
