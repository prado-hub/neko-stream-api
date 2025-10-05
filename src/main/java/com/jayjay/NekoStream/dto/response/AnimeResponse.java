package com.jayjay.NekoStream.dto.response;

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
