package com.example.bookshop.book;

import com.example.bookshop.genre.Genre;
import com.example.bookshop.publisher.Publisher;
import com.example.bookshop.author.Author;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int totalPages;
    @ManyToOne
    @JoinColumn(name="genre_id",foreignKey = @ForeignKey(name="fk_book_genre"))
    private Genre genre;
    @ManyToOne
    @JoinColumn(name="publisher_id",foreignKey =@ForeignKey(name="fk_book_publisher"))
    private Publisher publisher;
    @ManyToOne
    @JoinColumn(name="author_id",foreignKey =@ForeignKey(name="fk_book_author"))
    private Author author;
    private int yearPublished;
    private String shortDesc;
    private String language;

    public Book(){}
    public Book(String title,int totalPages,Genre genre,Publisher publisher,Author author,int yearPublished,String shortDesc,String language){
        this.title = title;
        this.totalPages = totalPages;
        this.genre = genre;
        this.publisher = publisher;
        this.author = author;
        this.yearPublished = yearPublished;
        this.shortDesc = shortDesc;
        this.language = language;
    }

    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return this.title;}
    public void setTitle(String title) {this.title = title;}
    public int getTotalPages() {return this.totalPages;}
    public void setTotalPages(int totalPages) {this.totalPages = totalPages;}
    public Genre getGenre() {return this.genre;}
    public void setGenre(Genre genre) {this.genre = genre;}
    public Publisher getPublisher() {return this.publisher;}
    public void setPublisher(Publisher publisher) {this.publisher = publisher;}
    public Author getAuthor() {return this.author;}
    public void setAuthor(Author author) {this.author = author;}
    public int getYearPublished() {return this.yearPublished;}
    public void setYearPublished(int yearPublished) {this.yearPublished = yearPublished;}
    public String getShortDesc() {return this.shortDesc;}
    public void setShortDesc(String shortDesc) {this.shortDesc = shortDesc;}
    public String getLanguage() {return this.language;}
    public void setLanguage(String language) {this.language = language;}

}
