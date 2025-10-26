package com.example.bookshop.book.mapper;

import com.example.bookshop.author.Author;
import com.example.bookshop.book.Book;
import com.example.bookshop.book.dto.BookRequest;
import com.example.bookshop.book.dto.BookResponse;
import com.example.bookshop.genre.Genre;
import com.example.bookshop.publisher.Publisher;

public class BookMapper {

    public static BookResponse toResponse(Book book) {
        if (book == null) return null;

        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setTotalPages(book.getTotalPages());
        response.setYearPublished(book.getYearPublished());
        response.setShortDesc(book.getShortDesc());
        response.setLanguage(book.getLanguage());
        response.setAuthorName(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
        response.setGenreName(book.getGenre().getName());
        response.setPublisherName(book.getPublisher().getName());

        return response;
    }

    public static Book toEntity(BookRequest dto, Author author, Genre genre, Publisher publisher) {
        if (dto == null) return null;

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setTotalPages(dto.getTotalPages());
        book.setYearPublished(dto.getYearPublished());
        book.setShortDesc(dto.getShortDesc());
        book.setLanguage(dto.getLanguage());
        book.setAuthor(author);
        book.setGenre(genre);
        book.setPublisher(publisher);

        return book;
    }

}
