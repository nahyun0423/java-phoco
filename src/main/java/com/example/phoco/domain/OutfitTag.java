package com.example.phoco.domain;

import jakarta.persistence.ManyToOne;

public class OutfitTag {

    @ManyToOne
    private Outfit outfitId;

    @ManyToOne
    private Tag tagId;
}
