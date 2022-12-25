package com.manicheva.FantasyGameSpring.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "image_url")
    private int imageUrl;
    @Column(name = "level")
    private int level;
    @Column(name = "points")
    private int points;


}
