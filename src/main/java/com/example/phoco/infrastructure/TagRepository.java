package com.example.phoco.infrastructure;

import com.example.phoco.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Iterable<Tag> findByTagNameContaining(String tagName);
}
