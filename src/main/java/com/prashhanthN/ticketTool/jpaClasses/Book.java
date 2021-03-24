package com.prashhanthN.ticketTool.jpaClasses;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    private String book_name;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="book_authors",joinColumns = {@JoinColumn(name="book_id")},inverseJoinColumns = {@JoinColumn(name="author_id")})
    private List<Author> authors= new ArrayList<>();

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
