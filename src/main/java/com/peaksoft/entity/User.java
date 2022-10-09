package com.peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String lastname;
    private int age;

    public User(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @OneToOne(cascade = {PERSIST, REFRESH, REMOVE, DETACH, MERGE}, fetch = FetchType.LAZY, mappedBy = "user")
    private Phone phone;

    @OneToMany(cascade = ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Course> courseList;

    @ManyToMany(cascade = ALL, mappedBy = "userList")
    private List<SocialMedia> socialMedias;
    public void setSocialMedia(SocialMedia socialMedia){
        if (socialMedias == null){
            socialMedias = new ArrayList<>();
            socialMedias.add(socialMedia);
        }
    }

}
