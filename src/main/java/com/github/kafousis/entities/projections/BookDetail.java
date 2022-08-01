package com.github.kafousis.entities.projections;

import com.github.kafousis.entities.Author;
import com.github.kafousis.entities.Book;
import com.github.kafousis.entities.Genre;
import com.github.kafousis.entities.Publisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "bookDetail", types = {Book.class})
public interface BookDetail {

    Long getId();
    String getTitle();
    String getIsbn();
    Integer getTotalPages();
    Integer getPublishedYear();

    @Value("#{target.publisher}")
    Publisher getPublisherDetails();
    @Value("#{target.genre}")
    Genre getGenreDetails();
    @Value("#{target.authors}")
    Set<Author> getAuthorsDetails();

    @Value("#{target.authors.size()}")
    Integer getAuthorsSize();

    // https://www.baeldung.com/spring-expression-language
    @Value("#{target.authors.size() == 2 ? target.authors[0].fullName + ', ' + target.authors[1].fullName : target.authors[0].fullName}")
    String getAllAuthors();
}
