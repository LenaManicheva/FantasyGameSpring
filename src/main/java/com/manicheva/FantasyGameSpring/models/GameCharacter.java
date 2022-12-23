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
@ToString
public class GameCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "imageurl")
    private String imageUrl;
    @OneToMany(mappedBy = "character")
    private List<Person> people;


}
