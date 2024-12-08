package com.example.phoco.application;

import com.example.phoco.domain.Favorites;
import com.example.phoco.infrastructure.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public void addToFavorites(Long userId, Long outfitId) {
        Favorites favorites = new Favorites();
        favorites.setUserId(userId);
        favorites.setFavoriteOutfit(outfitId);
        favoriteRepository.save(favorites);
    }
}
