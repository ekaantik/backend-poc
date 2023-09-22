package com.poc.ecard.repository;


import com.poc.ecard.entity.UserContactBook;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserContactBookRepo extends JpaRepository<UserContactBook, Long> {
//    List<UserContactBookRepo> findByMobileNumAndContactNumber(String userMobileNum, String contactNumber );
//    Optional<User> uploadContacts(String mobileNum);
//    List<UserContactBook> deleteByUserMobileNumAndContactNumber(String userMobileNum, String contactNumber );
//    @Modifying
@Transactional
@Modifying
void deleteByUserMobileNum(String userMobileNum );

    Optional<UserContactBook> findByUserMobileNum(String userMobileNum );
    List<UserContactBook> findByFirstName(String firstName);


//    @Query("delete from user_contact_book f where f.user_mobile_num=:num and f.contact_number=:number")
//    List<UserContactBookRepo> deleteUserContactBookRepo(@Param("num") String num, @Param("number") String number );

}
