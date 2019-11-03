package com.datacompass.user;

import com.datacompass.entity.User;
import com.datacompass.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findByUser(User user);

}
