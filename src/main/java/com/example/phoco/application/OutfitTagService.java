package com.example.phoco.application;

import com.example.phoco.domain.Outfit;
import com.example.phoco.domain.OutfitTag;
import com.example.phoco.domain.Tag;
import com.example.phoco.infrastructure.OutfitRepository;
import com.example.phoco.infrastructure.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OutfitTagService {

    private final OutfitRepository outfitRepository;
    private final TagRepository tagRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public Outfit createOutfitWithTags(String imagePath, Long userId, List<String> tagNames) {
        Outfit outfit = new Outfit();
        outfit.setImagePath(imagePath);
        outfit.setUserId(userId);

        List<OutfitTag> outfitTags = new ArrayList<>();
        for (String tagName : tagNames) {
            Tag tag = new Tag();
            tag.setTagName(tagName);

            OutfitTag outfitTag = new OutfitTag();
            outfitTag.setOutfit(outfit);
            outfitTag.setTag(tag);

            outfitTags.add(outfitTag);
        }
        outfit.setOutfitTags(outfitTags);

        return outfit;
    }

    public Outfit uploadOutfitWithTags(MultipartFile file, Long userId, List<String> tagNames) throws IOException {
        String savedFilePath = saveFileToLocal(file);
        Outfit outfit = createOutfitWithTags(savedFilePath, userId, tagNames);

        for (OutfitTag outfitTag : outfit.getOutfitTags()) {
            tagRepository.save(outfitTag.getTag());
        }

        return outfitRepository.save(outfit);
    }

    private String saveFileToLocal(MultipartFile file) throws IOException {
       //디렉토리 존재하지 않을 때 생성
        java.nio.file.Path dirPath = Paths.get(uploadDir);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        //파일 이름 중복 방지
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = dirPath.resolve(fileName);
        Files.write(filePath, file.getBytes());

        return filePath.toString();
    }
}

