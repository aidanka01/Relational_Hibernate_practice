package com.peaksoft.entity;

import com.peaksoft.util.Util;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "social_medias")
@Getter
@Setter
@NoArgsConstructor
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "users_social_medias",
            joinColumns = @JoinColumn(name = "social_media_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userList;

    public SocialMedia(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        if (userList == null) {
            userList = new ArrayList<>();
        }
       userList.add(user);
        user.setSocialMedia(this);

    }
}
