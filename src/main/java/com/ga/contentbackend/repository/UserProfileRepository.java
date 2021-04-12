package com.ga.contentbackend.repository;

import com.ga.contentbackend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository <UserProfile, Long> {

}
