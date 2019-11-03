package com.datacompass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @JsonIgnore
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "MANDATORY_PASS_RESET")
    private Boolean mandatoryPassReset;

    @Column(name = "LOGIN_STATUS")
    private Boolean loginStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_PASSWORD_CHANGE")
    private Date lastPasswordChange;

    @Column(name = "UNSUCCESSFUL_LOGIN")
    private Integer unsuccessfulLogin;

    @JsonIgnore
    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private UserProfile profile;

    public User(Long id, String firstName, String lastName, String username, String email, String password, Boolean active, Boolean mandatoryPassReset, Boolean loginStatus, Date lastLogin, Date lastPasswordChange, Integer unsuccessfulLogin, Integer profiles) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.mandatoryPassReset = mandatoryPassReset;
        this.loginStatus = loginStatus;
        this.lastLogin = lastLogin;
        this.lastPasswordChange = lastPasswordChange;
        this.unsuccessfulLogin = unsuccessfulLogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getMandatoryPassReset() {
        return mandatoryPassReset;
    }

    public void setMandatoryPassReset(Boolean mandatoryPassReset) {
        this.mandatoryPassReset = mandatoryPassReset;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public Integer getUnsuccessfulLogin() {
        return unsuccessfulLogin;
    }

    public void setUnsuccessfulLogin(Integer unsuccessfulLogin) {
        this.unsuccessfulLogin = unsuccessfulLogin;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (active != null ? !active.equals(user.active) : user.active != null) return false;
        if (mandatoryPassReset != null ? !mandatoryPassReset.equals(user.mandatoryPassReset) : user.mandatoryPassReset != null)
            return false;
        if (loginStatus != null ? !loginStatus.equals(user.loginStatus) : user.loginStatus != null) return false;
        if (lastLogin != null ? !lastLogin.equals(user.lastLogin) : user.lastLogin != null) return false;
        if (lastPasswordChange != null ? !lastPasswordChange.equals(user.lastPasswordChange) : user.lastPasswordChange != null)
            return false;
        if (unsuccessfulLogin != null ? !unsuccessfulLogin.equals(user.unsuccessfulLogin) : user.unsuccessfulLogin != null)
            return false;
        return profile != null ? profile.equals(user.profile) : user.profile == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (mandatoryPassReset != null ? mandatoryPassReset.hashCode() : 0);
        result = 31 * result + (loginStatus != null ? loginStatus.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (lastPasswordChange != null ? lastPasswordChange.hashCode() : 0);
        result = 31 * result + (unsuccessfulLogin != null ? unsuccessfulLogin.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", mandatoryPassReset=" + mandatoryPassReset +
                ", loginStatus=" + loginStatus +
                ", lastLogin=" + lastLogin +
                ", lastPasswordChange=" + lastPasswordChange +
                ", unsuccessfulLogin=" + unsuccessfulLogin +
                ", profile=" + profile +
                '}';
    }
}
