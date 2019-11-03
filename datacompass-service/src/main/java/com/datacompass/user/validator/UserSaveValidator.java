package com.datacompass.user.validator;

import com.datacompass.entity.User;
import com.datacompass.exception.UserEmailUnavaibleException;
import com.datacompass.exception.UserFirstNameAndLastNameUnavaibleException;
import com.datacompass.exception.UserNameUnavaibleException;
import com.datacompass.user.UserRepository;
import com.datacompass.user.dto.UserInputDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserSaveValidator implements ConstraintValidator<IUserSaveValidator, UserInputDTO> {

    private UserRepository userRepository;

    UserSaveValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(IUserSaveValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserInputDTO inputDto, ConstraintValidatorContext context) {

        User user;

        // valida se email já existe
        user = userRepository.findByEmail(inputDto.getEmail());
        if (user != null)
            throw new UserEmailUnavaibleException();

        //Valida se nome já existe
        user = userRepository.findByFirstNameAndLastName(inputDto.getFirstName(), inputDto.getLastName());
        if (user != null)
            throw new UserFirstNameAndLastNameUnavaibleException();

        //Valida se username já existe
        user = userRepository.findByUsername(inputDto.getUserName());
        if(user != null)
            throw new UserNameUnavaibleException();

        return true;
    }

}
