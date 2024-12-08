package com.example.phoco.infrastructure;

import com.example.phoco.domain.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorites, Long> {
}
