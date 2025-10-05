package com.jayjay.NekoStream.controller;

import com.jayjay.NekoStream.dto.request.GenreRequest;
import com.jayjay.NekoStream.dto.response.GenreResponse;
import com.jayjay.NekoStream.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    //get - list all genre
    @GetMapping()
    public List<GenreResponse> listGenres(){
        return genreService.listGenre();
    }

    //get - list genre by id
    @GetMapping("/{id}")
    public Optional<GenreResponse> listGenreById(@PathVariable Long id){
        return genreService.listGenreById(id);
    }

    // post - register a new genre
    @PostMapping()
    public GenreResponse createGenre(@RequestBody GenreRequest genre){
        return genreService.createGenre(genre);
    }

    //delete - delete a genre
    @DeleteMapping("/{id}")
    public void DeleteGenre(@PathVariable Long id){
        genreService.deleteGenre(id);
    }

}
