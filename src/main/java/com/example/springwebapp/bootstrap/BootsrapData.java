package com.example.springwebapp.bootstrap;

import com.example.springwebapp.domain.Author;
import com.example.springwebapp.domain.Book;
import com.example.springwebapp.repositories.AuthorRepositry;
import com.example.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
// it means tha i want Spring to detect that component when is starts up
public class BootsrapData implements CommandLineRunner {

    private final AuthorRepositry authorRepositry;
    private final BookRepository bookRepository;

    public BootsrapData(AuthorRepositry authorRepositry, BookRepository bookRepository) {
        this.authorRepositry = authorRepositry;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Momo");
        author.setLastName("Benks");

        Book book = new Book();
        book.setTitle("Learning Spring Boot");
        book.setIsbn("2023 Aug");

        Author authorSaved = authorRepositry.save(author);
        Book bookSaved = bookRepository.save(book);


        Author authorSecond = new Author();
        authorSecond.setFirstName("Momo");
        authorSecond.setLastName("Benks");

        Book bookSecond = new Book();
        bookSecond.setTitle("Learning Spring Boot 2");
        bookSecond.setIsbn("2023 Sep");

        Author authorSecondSaved = authorRepositry.save(authorSecond);
        Book bookSecondSaved = bookRepository.save(bookSecond);

        authorSaved.getBooks().add(bookSaved);
        authorSecondSaved.getBooks().add(bookSecondSaved);


        System.out.println("In boostrap");
        System.out.println("Author count : " + authorRepositry.count());
        System.out.println("Book count : " + bookRepository.count());
    }
}











