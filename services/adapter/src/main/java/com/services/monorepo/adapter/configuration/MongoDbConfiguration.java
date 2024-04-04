package com.services.monorepo.adapter.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MongoDbConfiguration extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    String database;

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
