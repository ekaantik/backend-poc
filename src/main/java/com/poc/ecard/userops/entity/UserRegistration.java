package com.poc.ecard.userops.entity;

import com.poc.ecard.entity.base.BaseUuidEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class UserRegistration extends BaseUuidEntity {

    private String user_num;
    private String phone_book_num;

}
