package com.example.springwebapp.repositories;

import com.example.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositry extends CrudRepository<Author, Long > {

}
