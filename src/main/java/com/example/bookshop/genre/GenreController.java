package com.example.bookshop.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> getAll(){
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id){
        Optional<Genre> genre=genreService.getGenreById(id);
        return genre.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre){
        return genreService.createGenre(genre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional> deleteGenre(@PathVariable Long id){
        genreService.deleteGenre(id);
        return ResponseEntity.ok().build();
    }

}
