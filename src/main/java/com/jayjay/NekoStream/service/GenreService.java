package com.jayjay.NekoStream.service;

import com.jayjay.NekoStream.dto.request.GenreRequest;
import com.jayjay.NekoStream.dto.response.GenreResponse;
import com.jayjay.NekoStream.entity.Genre;
import com.jayjay.NekoStream.mapper.GenreMapper;
import com.jayjay.NekoStream.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;


    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    public List<GenreResponse> listGenre(){
      return genreRepository.findAll()
              .stream()
              .map(genreMapper::toResponse)
              .toList();
    }

    public Optional<GenreResponse> listGenreById(Long id){
        return genreRepository.findById(id)
                .map(genreMapper::toResponse);
    }

    public GenreResponse createGenre(GenreRequest genre){
        Genre genreCreated = genreMapper.toEntity(genre);
        genreRepository.save(genreCreated);
        return genreMapper.toResponse(genreCreated);
    }

    public void deleteGenre(Long id){
        genreRepository.deleteById(id);
    }
}
