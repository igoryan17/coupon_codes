package com.podliva.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan("com.podliva.db")
@PropertySource("classpath:db/connection.properties")
@EnableMongoRepositories("com.podliva.db.repositories")
public class DbConfiguration {
    @Autowired
    Environment env;


}
