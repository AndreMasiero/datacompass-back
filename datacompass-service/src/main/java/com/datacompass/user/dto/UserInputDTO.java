package com.datacompass.user.dto;

import com.datacompass.user.validator.IUserSaveValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@IUserSaveValidator
public class UserInputDTO {

    private Long id;

    @NotNull(message = "Preenchimento obrigatório")
    private Integer profile;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 20, message = "O tamanho deve ser entre 3 e 20 caracteres")
    private String firstName;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 e 50 caracteres")
    private String lastName;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 20, message = "O tamanho deve ser entre 3 e 20 caracteres")
    private String userName;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 20, message = "O tamanho deve ser entre 5 e 20 caracteres")
    private String password;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 50, message = "O tamanho deve ser entre 5 e 50 caracteres")
    private String email;

    private Boolean temporary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTemporary() {
        return temporary;
    }

    public void setTemporary(Boolean temporary) {
        this.temporary = temporary;
    }

}
