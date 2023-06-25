package com.poc.ecard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPhoneBookRepository extends JpaRepository<UserPhoneBook,Long> {
     String query="select user_num from user_phone_book where user_num IN" +
                     "(select  user_num from user_phone_book where  user_num IN " +
                        "(select  user_num from user_phone_book where user_num IN " +
                           "(Select phone_book_num from user_phone_book where user_num = :s1)" +
                        ") " +
                     "and phone_book_num = :s1) " +
                   "and phone_book_num = :s2";

    @Query(value = "Select upb from UserPhoneBook upb where upb.user_num= :no")
    List<UserPhoneBook> findByUser_num(@Param("no") String userNum);
    @Query(value = query, nativeQuery = true)
    List<String> getCommonContactsByUserPhoneBook(@Param("s1") String s1, @Param("s2") String s2);
}