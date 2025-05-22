package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<ImagePageResponse> getImages(
        @RequestParam(required = false) Long cursorId,
        @RequestParam(defaultValue = "2") int size
    ) {
        ImagePageResponse response = imageService.getImages(cursorId, size);
        return ResponseEntity.ok(response);
    }
}
