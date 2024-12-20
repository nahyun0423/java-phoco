package com.example.phoco.infrastructure;

import com.example.phoco.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Iterable<Tag> findByTagNameContaining(String tagName);
}
