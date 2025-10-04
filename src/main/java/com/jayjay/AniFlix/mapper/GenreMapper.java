package com.jayjay.AniFlix.mapper;

import com.jayjay.AniFlix.dto.request.GenreRequest;
import com.jayjay.AniFlix.dto.response.GenreResponse;
import com.jayjay.AniFlix.entity.Genre;
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
