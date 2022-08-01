package com.server.ToyProject.entity;

import java.util.Date;
import java.util.Set;
//import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Getter
@Entity // This tells Hibernate to make a table out of this class
@Table(name="user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
    private String uuid;

    @Setter
    private String name;

    private String email;

    @Setter
    private Date lastLoginAt;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
       name = "user_authority",
       joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
       inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    // public User(){
    //     this.uuid = UUID.randomUUID().toString();
    // }

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
