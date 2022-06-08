package com.server.ToyProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Item extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    private Integer user_id;

    private String type;

    private String stats;

    public Item(){
        this.type = "WEAPON";
    }

    public Item(String type, String stats){
        this.type = type;
        this.stats = stats;
    }

    public static void main(String[] args){
        Item item = new Item("Weapon","damage:1");
        System.out.println(item);
    }
}
