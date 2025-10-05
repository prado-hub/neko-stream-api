package com.jayjay.NekoStream.controller;

import com.jayjay.NekoStream.dto.request.AnimeRequest;
import com.jayjay.NekoStream.dto.response.AnimeResponse;
import com.jayjay.NekoStream.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    //get - list all animes
    @GetMapping()
    public List<AnimeResponse> listAnime(){
        return animeService.listAnime();
    }

    //get - list of anime by id
    @GetMapping("/{id}")
    public Optional<AnimeResponse> listAnimeById(@PathVariable Long id){
        return animeService.listAnimeById(id);
    }

    //post - register a new anime
    @PostMapping()
    public AnimeResponse createAnime(@RequestBody AnimeRequest anime){
        return animeService.createAnime(anime);
    }

    //delete - delete an anime
    @DeleteMapping("/{id}")
    public void deleteAnime(@PathVariable Long id){
        animeService.deleteAnime(id);
    }
}
