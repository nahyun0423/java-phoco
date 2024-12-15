package com.example.phoco;

import com.example.phoco.application.FavoritesService;
import com.example.phoco.domain.Favorites;
import com.example.phoco.domain.User;
import com.example.phoco.infrastructure.FavoritesRepository;
import com.example.phoco.infrastructure.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class FavoritesServiceTest {
    @InjectMocks
    private FavoritesService favoritesService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private FavoritesRepository favoritesRepository;

    @Test
    void 즐겨찾기_생성_테스트() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("TestUser");

        Long favoriteId = 2L;
        String favoriteType = "USER";
        Favorites favorite = favoritesService.createFavorite(user, favoriteId, favoriteType);

        assertNotNull(favorite);
        assertEquals(user, favorite.getUser());
        assertEquals(favoriteId, favorite.getFavoriteId());
        assertEquals(favoriteType, favorite.getFavoriteType());
    }

    @Test
    void 즐겨찾기_추가_테스트() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("TestUser");

        Long favoriteId = 2L;
        String favoriteType = "OUTFIT";

        Favorites favorite = favoritesService.createFavorite(user, favoriteId, favoriteType);

        assertNotNull(favorite);
        assertEquals(user, favorite.getUser());
        assertEquals(favoriteId, favorite.getFavoriteId());
        assertEquals(favoriteType, favorite.getFavoriteType());
    }

}
