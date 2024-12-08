package com.example.phoco.presentation;


import com.example.phoco.application.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @PostMapping("/add")
    public String addToFavorites(@RequestParam("userId") Long userId, @RequestParam("outfitId") Long outfitId) {
        favoritesService.addToFavorites(userId, outfitId);
        return "즐겨찾기 추가";
    }
}
