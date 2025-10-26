package com.example.bookshop.book.dto;

public class BookRequest {
    private String title;
    private Integer totalPages;
    private Integer yearPublished;
    private String shortDesc;
    private String language;
    private Long authorId;
    private Long genreId;
    private Long publisherId;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getTotalPages() { return totalPages; }
    public void setTotalPages(Integer totalPages) { this.totalPages = totalPages; }

    public Integer getYearPublished() { return yearPublished; }
    public void setYearPublished(Integer yearPublished) { this.yearPublished = yearPublished; }

    public String getShortDesc() { return shortDesc; }
    public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public Long getGenreId() { return genreId; }
    public void setGenreId(Long genreId) { this.genreId = genreId; }

    public Long getPublisherId() { return publisherId; }
    public void setPublisherId(Long publisherId) { this.publisherId = publisherId; }
}
