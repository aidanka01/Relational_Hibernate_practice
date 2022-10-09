package com.peaksoft.entity;

import javax.persistence.*;

@Entity
@Table(name = "phones")

public class Phone {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Phone( String name, int number) {
        this.name = name;
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Phone(User user) {
        this.user = user;
    }

    public Phone() {
    }
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
