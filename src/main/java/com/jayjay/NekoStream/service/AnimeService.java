package com.jayjay.NekoStream.service;

import com.jayjay.NekoStream.dto.request.AnimeRequest;
import com.jayjay.NekoStream.dto.response.AnimeResponse;
import com.jayjay.NekoStream.entity.Anime;
import com.jayjay.NekoStream.mapper.AnimeMapper;
import com.jayjay.NekoStream.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;
    private final AnimeMapper animeMapper;

    public AnimeService(AnimeRepository animeRepository, AnimeMapper animeMapper) {
        this.animeRepository = animeRepository;
        this.animeMapper = animeMapper;
    }

    public List<AnimeResponse> listAnime(){
        return animeRepository.findAll().stream()
                .map(animeMapper::toResponse)
                .toList();
    }

    public Optional<AnimeResponse> listAnimeById(Long id){
        return animeRepository.findById(id)
                .map(animeMapper::toResponse);
    }

    public AnimeResponse createAnime(AnimeRequest anime){
        Anime animeCreated = animeMapper.toEntity(anime);
        animeRepository.save(animeCreated);
        return animeMapper.toResponse(animeCreated);
    }

    public void deleteAnime(Long id){
        animeRepository.deleteById(id);
    }
}
