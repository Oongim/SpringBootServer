package com.server.ToyProject.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Getter
@Entity // This tells Hibernate to make a table out of this class
public class User extends BaseEntity{
    @Id
    private String uuid;

    @Setter
    private String name;

    private String email;

    @Setter
    private Date lastLoginAt;

    public User(){
        this.uuid = UUID.randomUUID().toString();
    }

    public User(String uuid, String email){
        this.uuid = uuid;
        this.email = email;
    }

    public User(String uuid, String name, String email){
        this.uuid = uuid;
        this.name = name;
        this.email = email;
    }

    public static User sample(){
        return new User("Park","park@gmail.com");
    }

    public static void main(String[] args){
        User user = new User("Kim","kim@gmail.com");
        System.out.println(user);
    }

}
