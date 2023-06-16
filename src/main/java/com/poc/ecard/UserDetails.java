package com.poc.ecard;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")

public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO
    private Long id;

    private String user_num;
    private String phone_book_num;

    public UserDetails(String userNum, String phoneBookNum) {
        user_num = userNum;
        phone_book_num = phoneBookNum;
    }
}
