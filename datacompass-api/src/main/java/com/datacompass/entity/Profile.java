package com.datacompass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "profile")
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;

    public Profile() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PROFILE")
    private String profile;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER
    )
    @JoinTable(name = "PROFILE_ROLE",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "profile")
    private UserProfile userProfile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;

        Profile profile1 = (Profile) o;

        if (id != null ? !id.equals(profile1.id) : profile1.id != null) return false;
        if (profile != null ? !profile.equals(profile1.profile) : profile1.profile != null) return false;
        if (roles != null ? !roles.equals(profile1.roles) : profile1.roles != null) return false;
        return userProfile != null ? userProfile.equals(profile1.userProfile) : profile1.userProfile == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (userProfile != null ? userProfile.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", profile='" + profile + '\'' +
                ", roles=" + roles +
                ", userProfile=" + userProfile +
                '}';
    }
}
