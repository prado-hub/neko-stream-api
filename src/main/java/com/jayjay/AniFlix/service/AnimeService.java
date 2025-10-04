package com.jayjay.AniFlix.service;

import com.jayjay.AniFlix.entity.Anime;
import com.jayjay.AniFlix.repository.AnimeRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> listAnime(){
        return animeRepository.findAll();
    }

    public Optional<Anime> listAnimeById(Long id){
        return animeRepository.findById(id);
    }

    public Anime createAnime(Anime anime){
        return animeRepository.save(anime);
    }

    public void deleteAnime(Long id){
        animeRepository.deleteById(id);
    }
}
