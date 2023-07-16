package com.poc.ecard.userops.repo;

import com.poc.ecard.repository.base.BaseUuidRepository;
import com.poc.ecard.userops.entity.UserRegistration;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepo extends BaseUuidRepository<UserRegistration> {
}
