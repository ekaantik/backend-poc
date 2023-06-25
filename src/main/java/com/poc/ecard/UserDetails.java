package com.poc.ecard;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
@EnableAutoConfiguration
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String user_num;
    private String phone_book_num;
    private String qr_code_image_path;
    private byte[] byte_code;

    public UserDetails(String userNum, String phoneBookNum, String qrCodePath, byte[] byteCode)
    {
        user_num=userNum;
        phone_book_num=phoneBookNum;
        qr_code_image_path=qrCodePath;
        byte_code=byteCode;
    }

}
