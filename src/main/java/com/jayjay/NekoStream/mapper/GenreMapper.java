package com.jayjay.NekoStream.mapper;

import com.jayjay.NekoStream.dto.request.GenreRequest;
import com.jayjay.NekoStream.dto.response.GenreResponse;
import com.jayjay.NekoStream.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    public Genre toEntity(GenreRequest  genreRequest){
        Genre genre = new Genre();
        genre.setName(genreRequest.name());
        return genre;
    }

    public GenreResponse toResponse(Genre genre){
        return new GenreResponse(genre.getId(), genre.getName());
    }
}
