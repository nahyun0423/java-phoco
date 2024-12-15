package com.example.phoco;

import com.example.phoco.application.OutfitTagService;
import com.example.phoco.domain.Outfit;
import com.example.phoco.domain.OutfitTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OutfitTagServiceTest {
    @InjectMocks
    private OutfitTagService outfitTagService;

    @Test
    void Outfit_생성_테스트() {
        String imagePath = "/path/image.jpg";
        Long userId = 1L;
        List<String> tagNames = List.of("summer", "blue");

        Outfit outfit = outfitTagService.createOutfitWithTags(imagePath, userId, tagNames);

        assertNotNull(outfit);
        assertEquals(imagePath, outfit.getImagePath());
        assertEquals(userId, outfit.getUserId());
        assertNotNull(outfit.getOutfitTags());
        assertEquals(tagNames.size(), outfit.getOutfitTags().size());

        for (int i = 0; i < tagNames.size(); i++) {
            OutfitTag outfitTag = outfit.getOutfitTags().get(i);
            assertNotNull(outfitTag.getTag());
            assertEquals(tagNames.get(i), outfitTag.getTag().getTagName());
        }
    }


}
