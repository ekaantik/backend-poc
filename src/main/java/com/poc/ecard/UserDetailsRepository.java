package com.poc.ecard;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    @Query(value = "Select ud from UserDetails ud where ud.user_num= :no")
    UserDetails findByUser_num(@Param("no") String userNum);

}