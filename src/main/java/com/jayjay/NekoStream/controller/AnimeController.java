package com.jayjay.NekoStream.controller;

import com.jayjay.NekoStream.dto.request.AnimeRequest;
import com.jayjay.NekoStream.dto.response.AnimeResponse;
import com.jayjay.NekoStream.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AnimeResponse>> listAnime(){
        return ResponseEntity.ok(animeService.listAnime());
    }

    //get - list of anime by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AnimeResponse>> listAnimeById(@PathVariable Long id){
        return ResponseEntity.ok(animeService.listAnimeById(id));
    }

    //post - register a new anime
    @PostMapping()
    public ResponseEntity<AnimeResponse> createAnime(@RequestBody AnimeRequest anime){
        return ResponseEntity.status(HttpStatus.CREATED).body(animeService.createAnime(anime));
    }

    //delete - delete an anime
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAnime(@PathVariable Long id){
        animeService.deleteAnime(id);
        return ResponseEntity.noContent().build();
    }
}
