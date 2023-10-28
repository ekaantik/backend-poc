package com.poc.ecard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_contact_book")
public class UserContactBook { //extends BaseUuidEntity
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String userMobileNum; // id column of user profile table
//    private String contactNumber;
    private String firstName;
    private String lastName;
    private String currentOccupation;
    private String linkedinProfileLink;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    public UserContactBook(String userMobileNumber, String firstName, String lastName, String currentOccupation, String linkedinProfileLink) {
        this.userMobileNum = userMobileNumber;
//        this.contactNumber = contactNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentOccupation = currentOccupation;
        this.linkedinProfileLink = linkedinProfileLink;
    }
}
