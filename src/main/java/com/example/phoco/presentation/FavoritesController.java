package com.example.phoco.presentation;

import com.example.phoco.application.FavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoritesController {

    private final FavoritesService favoritesService;

    // /favorites/1/10/favoriteType?favoriteType=USER
    @PostMapping("/{userId}/{favoriteId}/favoriteType")
    public ResponseEntity<String> addFavorite(
            @PathVariable Long userId,
            @PathVariable Long favoriteId,
            @RequestParam String favoriteType) {
        try {
            favoritesService.addFavorites(userId, favoriteId, favoriteType);
            return ResponseEntity.ok("Favorites 추가 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
