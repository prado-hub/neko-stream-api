package com.jayjay.NekoStream.controller;

import com.jayjay.NekoStream.dto.request.GenreRequest;
import com.jayjay.NekoStream.dto.response.GenreResponse;
import com.jayjay.NekoStream.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<GenreResponse>> listGenres(){
        return ResponseEntity.ok(genreService.listGenre());
    }

    //get - list genre by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<GenreResponse>> listGenreById(@PathVariable Long id){
        return ResponseEntity.ok(genreService.listGenreById(id));
    }

    // post - register a new genre
    @PostMapping()
    public ResponseEntity<GenreResponse> createGenre(@RequestBody GenreRequest genre){
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.createGenre(genre));
    }

    //delete - delete a genre
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteGenre(@PathVariable Long id){
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }

}
