package com.example.bookshop.genre;
import com.example.bookshop.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    public List<Genre> getAllGenres(){
        return this.genreRepository.findAll();
    }
    public Optional<Genre> getGenreById(Long id){
        return this.genreRepository.findById(id);
    }
    public Genre createGenre(Genre genre){
        return this.genreRepository.save(genre);
    }
    public void deleteGenre(Long id){
        if(this.genreRepository.existsById(id)){
            this.genreRepository.deleteById(id);
        }else{
            throw new RuntimeException("Genre not found");
        }
    }

}
