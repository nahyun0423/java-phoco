package com.example.phoco.application;

import com.example.phoco.domain.Favorites;
import com.example.phoco.domain.User;
import com.example.phoco.infrastructure.FavoritesRepository;
import com.example.phoco.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoritesService {

    private final UserRepository userRepository;
    private final FavoritesRepository favoritesRepository;

    public Favorites createFavorite(User user, Long favoriteId, String favoriteType) {
        Favorites favorite = new Favorites();
        favorite.setUser(user);
        favorite.setFavoriteId(favoriteId);
        favorite.setFavoriteType(favoriteType);
        return favorite;
    }

    public void addFavorites(Long userId, Long favoriteId, String favoriteType) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User를 찾을 수 없습니다."));

        Favorites favorite = createFavorite(user, favoriteId, favoriteType);
        favoritesRepository.save(favorite);
    }
}