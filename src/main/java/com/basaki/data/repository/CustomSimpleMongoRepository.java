package com.basaki.data.repository;

import java.lang.reflect.Field;
import java.util.UUID;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;


/**
 * {@code CustomSimpleMongoRepository} is a custom Mongo repository responsible
 * for inserting a new value for I field of ype UUID if it's null during
 * insertion.
 * <p/>
 *
 * @param <T> type of entity
 * @param <I> type of entity id
 * @author Indra Basak
 * @since 2/10/17
 */
public class CustomSimpleMongoRepository<T, I> extends SimpleMongoRepository<T, I>
        implements CustomMongoRepository<T, I> {

    private MongoEntityInformation<T, I> entityInformation;

    public CustomSimpleMongoRepository(
            MongoEntityInformation<T, I> metadata,
            MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.entityInformation = metadata;
    }

    @Override
    public <S extends T> S save(S entity) {
        Assert.notNull(entity, "Entity must not be null!");
        if (entityInformation.isNew(entity)) {
            Object id = entityInformation.getId(entity);
            if (id == null && UUID.class.equals(
                    entityInformation.getIdType())) {
                Field field = ReflectionUtils.findField(entity.getClass(),
                        entityInformation.getIdAttribute());
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, entity, UUID.randomUUID());
            }
        }

        return super.save(entity);
    }
}
