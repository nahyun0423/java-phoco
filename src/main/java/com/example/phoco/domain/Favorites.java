package com.example.phoco.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long favoriteId;

    //user 또는 outfit
    private String favoriteType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}