package com.datacompass.user.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserSaveValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IUserSaveValidator {

    String message() default "Erro ao salvar dados do usuário";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
