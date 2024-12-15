package com.example.phoco.infrastructure;

import com.example.phoco.domain.OutfitTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutfitTagRepository extends JpaRepository<OutfitTag, Long> {
}
