package com.jayjay.NekoStream.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record AnimeRequest(String title,
                           String description,
                           LocalDate releaseDate,
                           double rating,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt,
                           List<Long> genres,
                           List<Long> streamings) {
}
