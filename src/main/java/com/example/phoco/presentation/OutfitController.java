package com.example.phoco.presentation;

import com.example.phoco.application.OutfitTagService;
import com.example.phoco.domain.Outfit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/outfit")
@RequiredArgsConstructor
public class OutfitController {

    private final OutfitTagService outfitTagService;

    @PostMapping("/upload")
    public ResponseEntity<Outfit> uploadOutfit(
            @RequestParam("file") MultipartFile file,
            @RequestParam Long userId,
            @RequestParam List<String> tagNames) {
        try {
            Outfit outfit = outfitTagService.uploadOutfitWithTags(file, userId, tagNames);
            return ResponseEntity.ok(outfit);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
