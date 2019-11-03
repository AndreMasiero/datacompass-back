package com.datacompass.user;

import com.datacompass.entity.Role;
import com.datacompass.entity.User;
import com.datacompass.entity.UserProfile;
import com.datacompass.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        UserProfile userProfile = userProfileRepository.findByUser(user);

        List<Role> roles = userProfile.getProfile().getRoles();

        return new UserSS(user.getId(), user.getEmail(), user.getPassword(), roles);
    }
}
