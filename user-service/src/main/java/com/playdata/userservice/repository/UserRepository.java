package com.playdata.userservice.repository;

import com.playdata.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUuid(String uuid);

    Optional<User> findUserByUserId(String userId);
}
