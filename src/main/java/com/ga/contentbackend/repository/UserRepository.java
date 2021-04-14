package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAddress(String userEmailAddress);

    User findByEmailAddress(String emailAddress);
}
