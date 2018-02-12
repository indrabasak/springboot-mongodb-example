package com.basaki.config;

import com.basaki.Application;
import com.mongodb.Mongo;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * {@code MongoConfigurationIntegrationTests} represents functional tests for
 * {@code MongoConfiguration}.
 * <p/>
 *
 * @author Indra Basak
 * @since 02/11/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, properties =
        {"data.version=3.6.1", "data.host=localhost", "data.port=9999"})
@ActiveProfiles("test")
public class MongoConfigurationIntegrationTests {

    @Autowired
    private MongoConfiguration configuration;

    @Test
    public void testProperties() {
        assertEquals("3.6.1", configuration.getVersion());
        assertEquals("localhost", configuration.getHost());
        assertEquals(9999, configuration.getPort());
    }

    @Test
    public void testMongo() throws IOException {
        Mongo mongo = configuration.mongo();
        assertNotNull(mongo);
    }
}
