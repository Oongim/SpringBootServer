package com.server.ToyProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class UserProfile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;




    @ManyToOne
    private User user;


    
    @Setter
    private String name;

    private Integer level;

    private Integer exp;





    public UserProfile(User user){
        this.user = user;
        this.name = "User";
        this.level = 1;
        this.exp = 0;
    }

    public UserProfile(User user,String name){
        this.user = user;
        this.name = name;
        this.level = 1;
        this.exp = 0;
    }
}
