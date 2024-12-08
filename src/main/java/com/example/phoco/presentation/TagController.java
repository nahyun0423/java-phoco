package com.example.phoco.presentation;

import com.example.phoco.application.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/create")
    public String createTag(@RequestParam("tagname") String tagName) {
        tagService.createTag(tagName);
        return "태그 생성";
    }
}
