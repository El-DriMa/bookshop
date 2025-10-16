package com.example.bookshop.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id){
        return authorRepository.findById(id);
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
        }else{
            throw new RuntimeException("Author not found");
        }
    }
}
