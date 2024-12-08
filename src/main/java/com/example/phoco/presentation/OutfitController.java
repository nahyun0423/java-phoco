package com.example.phoco.presentation;

import com.example.phoco.application.OutfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/outfits")
public class OutfitController {

    @Autowired
    private OutfitService outfitService;

    @PostMapping("/upload")
    public String uploadOutfit(@RequestParam("userId") Long userId, @RequestParam("file") MultipartFile file) throws IOException {
            outfitService.uploadOutfit(userId, file);
            return "파일 업로드 성공";
    }
}
