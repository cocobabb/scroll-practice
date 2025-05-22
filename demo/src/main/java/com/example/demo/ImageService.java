package com.example.demo;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public ImagePageResponse getImages(Long cursorId, int size) {
        Pageable pageable = PageRequest.of(0, size);
        List<Image> images = imageRepository.findNextImages(cursorId, pageable);

        List<ImageResponse> items = images.stream()
            .map(img -> new ImageResponse(img.getId(), img.getImageUrl(), img.getDescription()))
            .toList();

        Long nextCursor = images.isEmpty() ? null : images.get(images.size() - 1).getId();
        boolean hasNext = images.size() == size;

        return new ImagePageResponse(items, nextCursor, hasNext);
    }
}


