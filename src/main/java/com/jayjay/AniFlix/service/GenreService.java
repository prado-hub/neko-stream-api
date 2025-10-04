package com.jayjay.AniFlix.service;

import com.jayjay.AniFlix.dto.request.GenreRequest;
import com.jayjay.AniFlix.dto.response.GenreResponse;
import com.jayjay.AniFlix.entity.Genre;
import com.jayjay.AniFlix.mapper.GenreMapper;
import com.jayjay.AniFlix.repository.GenreRepository;
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

    public GenreResponse createGenre(GenreRequest genre){
        Genre createdGenre = genreMapper.toEntity(genre);
        genreRepository.save(createdGenre);
        return genreMapper.toResponse(createdGenre);
    }

    public void deleteGenre(Long id){
        genreRepository.deleteById(id);
    }

    public GenreResponse updateGenre(Long id,GenreRequest genreAtt){
        Optional<Genre> genreVerify = genreRepository.findById(id);

        if(genreVerify.isEmpty()){
            return null;
        }else{
            genreAtt.setId(id);
            genreRepository.save(genreAtt);
            return genreMapper.toResponse();
        }
    }
}
