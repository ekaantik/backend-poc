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

    private String userProfileId; // id column of user profile table
    private String contactNumber;


}
