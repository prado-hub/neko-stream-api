package com.jayjay.AniFlix.controller;

import com.jayjay.AniFlix.entity.Genre;
import com.jayjay.AniFlix.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    //get - list all genre
    @GetMapping()
    public List<Genre> listGenres(){
        return genreService.listGenre();
    }

    // post - register a new genre
    @PostMapping()
    public Genre createGenre(@RequestBody Genre genre){
        return genreService.createGenre(genre);
    }

    //delete - delete a genre
    @DeleteMapping("/{id}")
    public void DeleteGenre(@PathVariable Long id){
        genreService.deleteGenre(id);
    }

    // update - update a genre
    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Long id,@RequestBody Genre genreAtt){
        return genreService.updateGenre(id,genreAtt);
    }
}
