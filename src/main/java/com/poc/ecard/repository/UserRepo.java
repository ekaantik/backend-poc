package com.poc.ecard.repository;


import com.poc.ecard.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByMobileNum(String mobileNum);
    @Transactional
    @Modifying
    void deleteByMobileNum(String mobileNum );
}
