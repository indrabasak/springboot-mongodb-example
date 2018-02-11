package com.basaki.config;

import com.basaki.data.repository.CustomSimpleMongoRepository;
import com.mongodb.Mongo;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import java.io.IOException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * {@code MongoConfiguration} configures embedded MongoDB.
 * <p/>
 *
 * @author Indra Basak
 * @since 02/10/18
 */
@Configuration
@EnableMongoRepositories(repositoryBaseClass = CustomSimpleMongoRepository.class,
        basePackages = {"com.basaki.data.repository"})
public class MongoConfiguration {

    @Setter
    @Value("${data.version:3.6.1}")
    private String version;

    @Setter
    @Value("${data.host:127.0.0.1}")
    private String host;

    @Setter
    @Value("${data.port:12345}")
    private int port;

    @Bean(destroyMethod = "close")
    public Mongo mongo() throws IOException {
        return new EmbeddedMongoBuilder()
                .version(version)
                .bindIp(host)
                .port(port)
                .build();
    }
}
