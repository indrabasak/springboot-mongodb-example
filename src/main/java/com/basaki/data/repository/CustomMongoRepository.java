package com.basaki.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * {@code CustomMongoRepository} is a custom Mongo repository.
 * <p/>
 *
 * @param <T>  type of entity
 * @param <I> type of entity id
 * @author Indra Basak
 * @since 2/10/17
 */
@NoRepositoryBean
public interface CustomMongoRepository<T, I> extends MongoRepository<T, I> {
}
