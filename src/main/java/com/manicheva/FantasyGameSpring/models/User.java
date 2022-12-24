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

public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Username must not be empty")
    @Size(min = 2, max = 100, message = "Size must be 2-100 symbols")
    @Column(name = "username")
    private String username;
    @NotEmpty(message = "Password should not be empty")
    @Column(name = "password")
    private String password;

    @Transient

    private String confirmPassword;
    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;


}
