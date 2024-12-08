package com.example.phoco.domain;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    private Long userId;
    private Long favoriteOutfit;
    private Long favoriteUser;
}
