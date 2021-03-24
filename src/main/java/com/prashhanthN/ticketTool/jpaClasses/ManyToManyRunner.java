package com.prashhanthN.ticketTool.jpaClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ManyToManyRunner  implements CommandLineRunner {

    @Autowired
     BookRepo repo;

    @Override
    public void run(String... args) throws Exception {
        Book b1= new Book();
        b1.setBook_name("Angular");
        b1.setBook_id(1574);

        Book b2= new Book();
        b2.setBook_id(2574);
        b2.setBook_name("AWS");

        Author balaswami= new Author();
        balaswami.setAuhtor_id(258);
        balaswami.setAuthor_name("Bala Guru Swami");
        Author schand= new Author();
        schand.setAuhtor_id(8794);
        schand.setAuthor_name("S. Chand");
        Author jk= new Author();
        jk.setAuhtor_id(5725);
        jk.setAuthor_name("JK Publication");

        b1.setAuthors(Arrays.asList(balaswami,jk));
        b2.setAuthors(Arrays.asList(balaswami,schand,jk));

        repo.save(b1);
        repo.save(b2);

    }
}
