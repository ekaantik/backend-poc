package com.poc.ecard;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
@Builder
public class UserDetails {

    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO)
    private Long uid;

    @Column(length = 30)
    private String user_name;


    private int user_age;


    @Column(length = 50)
    private String user_email;

    @Column(length = 500)
    private String user_description;

    @Column(length = 10)
    private String user_num;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userDetails")
    private List<UserPhoneBook> userPhoneBook;
}
