package com.poc.ecard;

import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String user_num;
    private String phone_book_num;

    public UserDetails(String userNum, String phoneBookNum )
    {
        user_num=userNum;
        phone_book_num=phoneBookNum;
    }

}
