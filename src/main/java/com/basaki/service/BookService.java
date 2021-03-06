package com.basaki.service;

import com.basaki.data.entity.Book;
import com.basaki.data.repository.BookRepository;
import com.basaki.error.exception.DataNotFoundException;
import com.basaki.model.BookRequest;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * {@code BookService} provides CRUD functioanality on book.
 * <p/>
 *
 * @author Indra Basak
 * @since 11/20/17
 */
@Service
@Slf4j
public class BookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Transactional
    public Book create(BookRequest request) {
        Book entity = validateRequest(request);
        return repository.save(entity);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Book read(UUID id) {
        Optional<Book> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }

        throw new DataNotFoundException("Book with ID " + id + " not found.");
    }

    private Book validateRequest(BookRequest request) {
        log.info("Validating book request!");

        Assert.notNull(request, "Book request cannot be empty!");
        Assert.notNull(request.getTitle(), "Book title cannot be missing!");
        Assert.notNull(request.getAuthor(), "Book author cannot be missing!");

        Book entity = new Book();
        entity.setTitle(request.getTitle());
        entity.setAuthor(request.getAuthor());

        return entity;
    }
}