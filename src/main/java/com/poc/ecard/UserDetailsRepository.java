package com.poc.ecard;


import com.poc.ecard.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    @Query(value = "select user_num from user_details where user_num IN(select  user_num from user_details where  user_num IN (select  user_num from user_details where user_num IN (Select phone_book_num from user_details where user_num = :s1)) and phone_book_num = :s1) and phone_book_num = :s2", nativeQuery = true)
    List<String> getCommonContactsByUserDetails(@Param("s1") String s1, @Param("s2") String s2);
}
