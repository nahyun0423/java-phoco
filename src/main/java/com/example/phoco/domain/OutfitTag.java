package com.example.phoco.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OutfitTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outfitTagId;

    @ManyToOne
    @JoinColumn(name = "outfit_id", nullable = false)
    private Outfit outfit;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}