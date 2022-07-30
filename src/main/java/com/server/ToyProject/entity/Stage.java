package com.server.ToyProject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonRawValue;
import com.server.ToyProject.converter.StringListConverter;

import lombok.Getter;

@Getter
@Entity
public class Stage extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User user;

    private Integer currentWave;

    @Column(columnDefinition = "json")
    @JsonRawValue
    private String cards;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "json")
    private String cardArrangement;

    public Stage(User user){
        this.user = user;
        this.currentWave = 0;
        this.cards = "new ArrayList<String>();";
        this.cardArrangement = "";
    }
}
