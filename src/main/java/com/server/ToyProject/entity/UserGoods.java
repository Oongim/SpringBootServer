package com.server.ToyProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Getter
@Entity
public class UserGoods extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User user;

    private Integer gold;

    private Integer crystal;

    public UserGoods(User user){
        this.user = user;
        this.gold = 0;
        this.crystal = 0;
    }
}
