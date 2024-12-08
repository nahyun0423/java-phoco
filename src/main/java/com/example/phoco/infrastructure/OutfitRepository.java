package com.example.phoco.infrastructure;

import com.example.phoco.domain.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitRepository extends JpaRepository<Outfit, Long> {
}
