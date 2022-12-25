package com.manicheva.FantasyGameSpring.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "character")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "character")
    private List<User> users;


    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
