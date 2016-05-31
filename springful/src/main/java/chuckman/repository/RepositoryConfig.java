package chuckman.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * Created by fernando.petroni on 5/31/16.
 */
@Configuration
public class RepositoryConfig {

    @Bean
    public MongoDatabase database(@Value("${chuckman.database.mongodb.url}") final String url,
                                  @Value("${chuckman.database.mongodb.port}") final String port,
                                  @Value("${chuckman.database.mongodb.database}") final String database,
                                  @Value("${chuckman.database.mongodb.username}") final String username,
                                  @Value("${chuckman.database.mongodb.password}") final String password) {
        MongoProperties properties = new MongoProperties(url, port, database, username, password);
        MongoClient mongoClient = null;
        try {
            mongoClient = createClient(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoClient.getDatabase("chuckman");
    }

    private MongoClient createClient(MongoProperties properties) throws Exception {
        List<MongoCredential> credentials = Collections.singletonList(mongoDBCredentials(properties));

        System.out.println("*****Configuring MongoDB url=" + properties.url + ", port=" + properties.port);

        return new MongoClient(
                new ServerAddress(properties.url, Integer.parseInt(properties.port)),
                credentials
        );
    }

    private MongoCredential mongoDBCredentials(MongoProperties properties) {
        return MongoCredential.createCredential(properties.username, properties.database,
                properties.password.toCharArray()
        );
    }

    private class MongoProperties {
        String url;
        String port;
        String database;
        String username;
        String password;

        public MongoProperties(String url, String port, String database, String username, String password) {
            this.url = url;
            this.port = port;
            this.database = database;
            this.username = username;
            this.password = password;
        }
    }

}
