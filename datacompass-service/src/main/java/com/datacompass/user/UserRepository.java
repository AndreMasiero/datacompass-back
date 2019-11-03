package com.datacompass.user;

import com.datacompass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByFirstNameAndLastName(String firstName, String LastName);

    User findByUsername(String username);

}
