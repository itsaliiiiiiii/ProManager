package com.promanager.promanager.Persistance;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

import java.util.HashMap;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connexion {
    MongoCollection<Document> collection;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private Document document;

    public Connexion(String dbName, String connectionURL) {
        mongoClient = MongoClients.create(connectionURL);
        database = mongoClient.getDatabase(dbName);
        document = new Document();
    }

    private MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    private void setCollection(String collectionName) {
        this.collection = this.getCollection(collectionName);
    }

    public void insert(String key, Object value, String collectionName) {
        this.setCollection(collectionName);
        document.append(key, value);
        collection.insertOne(document);
        document.clear();
    }

    public void insert(String key, List<Object> value, String collectionName) {
        this.setCollection(collectionName);
        document.append(key, value);
        collection.insertOne(document);
        document.clear();
    }

    public void insert(HashMap<String, Object> Object, String collectionName) {
        this.setCollection(collectionName);
        for (String key : Object.keySet()) {
            document.append(key, Object.get(key));
        }
        collection.insertOne(document);
        document.clear();
    }

    public void update(ObjectId keyOfObject, String key, Object value, String collectionName) {
        this.setCollection(collectionName);
        Document filter = new Document("_id", keyOfObject);
        Document update = new Document("$set", new Document(key, value));
        collection.updateOne(filter, update);
    }

    public void update(ObjectId keyOfObject, String key, List<Object> value, String collectionName) {
        this.setCollection(collectionName);
        Document filter = new Document("_id", keyOfObject);
        Document update = new Document("$set", new Document(key, value));
        collection.updateOne(filter, update);
    }

    public Document select(ObjectId keyOfObject, String collectionName) {
        this.setCollection(collectionName);
        Document filter = new Document("_id", keyOfObject);
        Document document = collection.find(filter).first();
        return document;
    }

    public FindIterable<Document> selectAll(String collectionName) {
        this.setCollection(collectionName);
        FindIterable<Document> documents = collection.find();
        return documents;
    }

    public void remove(ObjectId keyOfObject, String key, String collectionName) {
        this.setCollection(collectionName);
        Document filter = new Document("_id", keyOfObject);
        Document update = new Document("$unset", new Document(key, ""));
        collection.updateOne(filter, update);
    }

    public void remove(ObjectId keyOfObject, String collectionName) {
        this.setCollection(collectionName);
        Document filter = new Document("_id", keyOfObject);
        collection.deleteOne(filter);
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}