package com.poc.ecard;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_phone_book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPhoneBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO
    private Long pid;

    @Column(length = 10)
    private String phone_book_num;

    @Column(length = 10,nullable = false)
    private String user_num;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_details_uid")
    private UserDetails userDetails;

    public UserPhoneBook(String userNum,String phoneBookNum) {
        user_num=userNum;
        phone_book_num = phoneBookNum;
    }

}
