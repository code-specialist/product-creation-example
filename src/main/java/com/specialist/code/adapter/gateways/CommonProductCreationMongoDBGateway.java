package com.specialist.code.adapter.gateways;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.specialist.code.application.productcreation.boundaries.output.register.ICommonProductRegisterGateway;
import com.specialist.code.domain.IProduct;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class CommonProductCreationMongoDBGateway implements ICommonProductRegisterGateway {

    private static final String COMMON_PRODUCT_TABLE = "products";
    private final MongoCollection<Document> collection;

    public CommonProductCreationMongoDBGateway(String host, int port) {
        MongoDatabase database;
        MongoClient client = new MongoClient(host, port);
        database = client.getDatabase("commonProducts");
        collection = database.getCollection(COMMON_PRODUCT_TABLE);
    }

    @Override
    public void save(IProduct iProduct) {
        Document productMongoMapper = new Document();
        productMongoMapper.put("id", iProduct.getId());
        productMongoMapper.put("name", iProduct.getName());
        productMongoMapper.put("description", iProduct.getDescription());
        productMongoMapper.put("price", iProduct.getPrice());
        productMongoMapper.put("createdAt", iProduct.getCreatedAt());
        collection.insertOne(productMongoMapper);
    }

    @Override
    public boolean existsById(String id) {
        Document mongoMapper = collection.find(eq("id", id)).first();

        return mongoMapper != null;
    }
}
