package com.jayjay.AniFlix.dto.request;

import com.jayjay.AniFlix.entity.Genre;
import com.jayjay.AniFlix.entity.Streaming;

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
