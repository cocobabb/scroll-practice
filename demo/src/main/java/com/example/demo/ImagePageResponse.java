package com.example.demo;

import java.util.List;

public record ImagePageResponse(
    List<ImageResponse> items,
    Long nextCursor,
    boolean hasNext
) {}
