package com.playdata.userservice.repository;

import com.playdata.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUuid(String uuid);
}
