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
    private static Connexion instance;
    MongoCollection<Document> collection;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private Document document;

    private Connexion(String dbName, String connectionURL) {
        mongoClient = MongoClients.create(connectionURL);
        database = mongoClient.getDatabase(dbName);
        document = new Document();
    }

    public static Connexion getInstance(String dbName, String connectionURL) {
        if (instance == null) {
            instance = new Connexion(dbName, connectionURL);
        }
        return instance;
    }

    private MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    private void setCollection(String collectionName) {
        this.collection = this.getCollection(collectionName);
    }

    public void Duplicate(ObjectId id, String collectionName) {
        Document originDocument = select(id, collectionName);
        Document ClonerdDocument = new Document(originDocument);
        ClonerdDocument.remove("_id");
        this.insert(ClonerdDocument, collectionName);
    }

    private void insert(Document document, String collectionName) {
        setCollection(collectionName);
        collection.insertOne(document);
    }

    public void insert(String key, Object value, String collectionName) {
        this.setCollection(collectionName);
        document.append(key, value);
        collection.insertOne(document);
        document.clear();
    }

    public ObjectId insert(String key, List<ObjectId> value, String collectionName) {
        this.setCollection(collectionName);
        document.append(key, value);
        collection.insertOne(document);
        ObjectId id = document.getObjectId("_id");
        document.clear();
        return id;
    }

    public ObjectId insert(HashMap<String, Object> Object, String collectionName) {
        this.setCollection(collectionName);
        for (String key : Object.keySet()) {
            document.append(key, Object.get(key));
        }
        collection.insertOne(document);
        ObjectId id = document.getObjectId("_id");
        document.clear();
        return id;
    }

    public void update(ObjectId keyOfObject, String key, Object value, String collectionName) {
        this.setCollection(collectionName);
        Document filter = new Document("_id", keyOfObject);
        Document update = new Document("$set", new Document(key, value));
        collection.updateOne(filter, update);
    }
    public void update(ObjectId keyOfObject, String key, List<ObjectId> value, String collectionName) {
        this.setCollection(collectionName);
        Document filter = new Document("_id", keyOfObject);
        Document update = new Document("$set", new Document(key, value));
        collection.updateOne(filter, update);
    }

    public void update(ObjectId keyOfObject, HashMap<String, Object> Objects, String collectionName) {
        this.setCollection(collectionName);
        for (String key : Objects.keySet()) {
            Document filter = new Document("_id", keyOfObject);
            Document update = new Document("$set", new Document(key, Objects.get(key)));
            collection.updateOne(filter, update);
        }
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