package com.manicheva.FantasyGameSpring.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Username must not be empty")
    @Size(min = 2, max = 100, message = "Size must be 2-100 symbols")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Password must not be empty")
    @Column(name = "password")
    private String password;


}
