package com.example.phoco.application;

import com.example.phoco.domain.Outfit;
import com.example.phoco.infrastructure.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class OutfitService {

    @Autowired
    private OutfitRepository outfitRepository;

    public void uploadOutfit(Long userId, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String uploadDir = "uploads/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = uploadDir + fileName;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Outfit outfit = new Outfit();
        outfit.setImagePath(filePath);
        outfitRepository.save(outfit);
    }
}
