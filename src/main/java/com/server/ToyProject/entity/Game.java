package com.server.ToyProject.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.server.ToyProject.converter.StringListConverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@AllArgsConstructor
public class Game extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    @Column(updatable = true)
    private LocalDateTime finishedAt;

    @ManyToOne
    private User user;

    private Integer stage;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "json")
    private String killed;

    public Game(User user){
        this.user = user;   
        this.stage = 0;
        this.killed = "{}";
    }
}
