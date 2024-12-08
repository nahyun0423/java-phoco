package com.example.phoco.application;

import com.example.phoco.domain.Tag;
import com.example.phoco.infrastructure.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public void createTag(String tagName) {
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tagRepository.save(tag);
    }

    public Iterable<Tag> searchTags(String tagName) {
        return tagRepository.findByTagNameContaining(tagName);
    }
}
