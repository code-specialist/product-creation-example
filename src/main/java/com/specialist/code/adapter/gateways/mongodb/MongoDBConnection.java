package com.specialist.code.adapter.gateways.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public abstract class MongoDBConnection {
    protected final MongoDatabase database;

    public MongoDBConnection(String host, int port) {
        try (MongoClient client = new MongoClient(host, port)) {
            database = client.getDatabase("products");
        }
    }

}
