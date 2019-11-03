package com.datacompass.user;

import com.datacompass.entity.User;
import com.datacompass.exception.ObjectNotFoundException;
import com.datacompass.security.RolesAllowedConstants;
import com.datacompass.security.UserSS;
import com.datacompass.user.dto.UserInputDTO;
import com.datacompass.utils.UserAuthenticated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserInputDTO userInputDTO) {

        User user = new User(userInputDTO.getId(), userInputDTO.getFirstName(), userInputDTO.getLastName(), userInputDTO.getUserName(), userInputDTO.getEmail(), userInputDTO.getPassword(),
                true, userInputDTO.getTemporary(), true, null, null, 0, userInputDTO.getProfile());

        User save = userRepository.save(user);

        return save;
    }

    public User findByEmail(String email) {
        UserSS user = UserAuthenticated.authenticated();

        User obj = userRepository.findByEmail(email);
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + User.class.getName());
        }
        return obj;
    }

    public Page<User> findAll(Pageable pageable) {
        UserSS user = UserAuthenticated.authenticated();

        Page<User> obj = userRepository.findAll(pageable);
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + User.class.getName());
        }
        return obj;
    }

    public Boolean deleteUser(Long id) {
        UserSS user = UserAuthenticated.authenticated();
        if (user == null || !user.hasRole(RolesAllowedConstants.ADMIN)) {
//            throw new AuthorizationException("Acesso negado");
        }

        userRepository.deleteById(id);

        return true;
    }

}
