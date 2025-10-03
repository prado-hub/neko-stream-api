package com.jayjay.AniFlix.service;

import com.jayjay.AniFlix.entity.Genre;
import com.jayjay.AniFlix.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> listGenre(){
      return genreRepository.findAll();
    }

    public Genre createGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public void deleteGenre(Long id){
        genreRepository.deleteById(id);
    }

    public Genre updateGenre(Long id,Genre genreAtt){
        Optional<Genre> genreVerify = genreRepository.findById(id);
        if(genreVerify.isEmpty()){
            return null;
        }else{
            genreAtt.setId(id);
            return genreRepository.save(genreAtt);
        }
    }
}
