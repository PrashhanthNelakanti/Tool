package com.prashhanthN.ticketTool.jpaClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auhtor_id;
    private String author_name;

    public int getAuhtor_id() {
        return auhtor_id;
    }

    public void setAuhtor_id(int auhtor_id) {
        this.auhtor_id = auhtor_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
