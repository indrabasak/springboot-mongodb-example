package com.basaki.data.repository;

import com.basaki.data.entity.Book;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * {@code BookRepository} is a  MongoDB book repository for Book entity.
 * <p/>
 *
 * @author Indra Basak
 * @since 2/10/18
 */
@Repository
public interface BookRepository extends CustomMongoRepository<Book, UUID> {
}
