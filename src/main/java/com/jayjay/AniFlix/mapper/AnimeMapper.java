package com.jayjay.AniFlix.mapper;

import com.jayjay.AniFlix.dto.request.AnimeRequest;
import com.jayjay.AniFlix.dto.response.AnimeResponse;
import com.jayjay.AniFlix.dto.response.GenreResponse;
import com.jayjay.AniFlix.dto.response.StreamingResponse;
import com.jayjay.AniFlix.entity.Anime;
import com.jayjay.AniFlix.entity.Genre;
import com.jayjay.AniFlix.entity.Streaming;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class AnimeMapper {
    private final GenreMapper genreMapper;
    private final StreamingMapper streamingMapper;

    public AnimeMapper(GenreMapper genreMapper, StreamingMapper streamingMapper) {
        this.genreMapper = genreMapper;
        this.streamingMapper = streamingMapper;
    }

    public Anime toEntity(AnimeRequest animeRequest) {
        Anime anime = new Anime();

        List<Genre> genres = animeRequest.genres().stream()
                .map(genreId ->{
                    Genre genre = new Genre();
                    genre.setId(genreId);
                    return genre;
                })
                .toList();

        List<Streaming> streamings = animeRequest.streamings().stream()
                .map(streamingId ->{
                    Streaming streaming = new Streaming();
                    streaming.setId(streamingId);
                    return streaming;
                })
                .toList();

        anime.setTitle(animeRequest.title());
        anime.setDescription(animeRequest.description());
        anime.setReleaseDate(animeRequest.releaseDate());
        anime.setRating(animeRequest.rating());
        anime.setCreatedAt(animeRequest.createdAt());
        anime.setUpdatedAt(animeRequest.updatedAt());
        anime.setGenres(genres);
        anime.setStreamings(streamings);
        return anime;
    }

    public AnimeResponse toResponse(Anime anime){
        List<GenreResponse> genres = anime.getGenres().stream()
                .map(genreMapper::toResponse)
                .toList();

        List<StreamingResponse> streamings = anime.getStreamings().stream()
                .map(streamingMapper::toResponse)
                .toList();

        return new AnimeResponse(anime.getId(),
                anime.getTitle(),
                anime.getDescription(),
                anime.getReleaseDate(),
                anime.getRating(),
                anime.getCreatedAt(),
                anime.getUpdatedAt(),
                genres,
                streamings);
    }
}

