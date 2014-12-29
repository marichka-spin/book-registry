package com.bookregistry.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "Book_Author", joinColumns =
        @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns =
        @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<Author> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
