package com.example.bookshop.book;

import com.example.bookshop.author.Author;
import com.example.bookshop.author.AuthorRepository;
import com.example.bookshop.book.dto.BookRequest;
import com.example.bookshop.book.dto.BookResponse;
import com.example.bookshop.book.mapper.BookMapper;
import com.example.bookshop.genre.Genre;
import com.example.bookshop.genre.GenreRepository;
import com.example.bookshop.publisher.Publisher;
import com.example.bookshop.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       GenreRepository genreRepository,
                       PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toResponse)
                .toList();
    }

    public BookResponse createBook(BookRequest dto) {
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow();
        Genre genre = genreRepository.findById(dto.getGenreId()).orElseThrow();
        Publisher publisher = publisherRepository.findById(dto.getPublisherId()).orElseThrow();

        Book book = BookMapper.toEntity(dto, author, genre, publisher);
        Book saved = bookRepository.save(book);
        return BookMapper.toResponse(saved);
    }

    public BookResponse updateBook(Long id, BookRequest dto) {

        Book existing = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));


        if (dto.getTitle() != null) existing.setTitle(dto.getTitle());
        if (dto.getTotalPages() != 0) existing.setTotalPages(dto.getTotalPages());
        if (dto.getYearPublished() != 0) existing.setYearPublished(dto.getYearPublished());
        if (dto.getShortDesc() != null) existing.setShortDesc(dto.getShortDesc());
        if (dto.getLanguage() != null) existing.setLanguage(dto.getLanguage());

        if (dto.getAuthorId() != null)
            existing.setAuthor(authorRepository.findById(dto.getAuthorId()).orElseThrow());
        if (dto.getGenreId() != null)
            existing.setGenre(genreRepository.findById(dto.getGenreId()).orElseThrow());
        if (dto.getPublisherId() != null)
            existing.setPublisher(publisherRepository.findById(dto.getPublisherId()).orElseThrow());

        Book saved = bookRepository.save(existing);

        return BookMapper.toResponse(saved);
    }

    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return BookMapper.toResponse(book);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
