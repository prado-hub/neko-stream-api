package com.jayjay.AniFlix.dto.response;

import com.jayjay.AniFlix.entity.Genre;
import com.jayjay.AniFlix.entity.Streaming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record AnimeResponse(Long Id,
                            String title,
                            String description,
                            LocalDate releaseDate,
                            double rating,
                            LocalDateTime createdAt,
                            LocalDateTime updatedAt,
                            List<GenreResponse> genres,
                            List<StreamingResponse> streamings) {
}
