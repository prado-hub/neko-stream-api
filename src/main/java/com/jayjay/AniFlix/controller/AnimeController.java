package com.jayjay.AniFlix.controller;

import com.jayjay.AniFlix.entity.Anime;
import com.jayjay.AniFlix.service.AnimeService;
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
    public List<Anime> listAnime(){
        return animeService.listAnime();
    }

    //get - list of anime by id
    @GetMapping("/{id}")
    public Optional<Anime> listAnimeById(@PathVariable Long id){
        return animeService.listAnimeById(id);
    }

    //post - register a new anime
    @PostMapping()
    public Anime createAnime(@RequestBody Anime anime){
        return animeService.createAnime(anime);
    }

    //delete - delete an anime
    @DeleteMapping("/{id}")
    public void deleteAnime(@PathVariable Long id){
        animeService.deleteAnime(id);
    }
}
