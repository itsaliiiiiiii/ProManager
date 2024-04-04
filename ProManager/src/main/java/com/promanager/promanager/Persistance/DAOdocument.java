package com.promanager.promanager.Persistance;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.promanager.promanager.Metier.POJO.Document_;

public class DAOdocument {
    Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");

    public ArrayList<Document_> getAll() {
        ArrayList<Document_> Documents = new ArrayList<>();
        FindIterable<Document> documents = connexion.selectAll("Documents");
        Document_ Document;
        for (Document document : documents) {
            Document = new Document_();
            Document.setIdDocument(document.getObjectId("_id"));
            Document.setDescriptionDocument(document.getString("Description"));
            Document.setPathDocument(document.getString("Path"));
            Documents.add(Document);
        }
        return Documents;
    }

    public Document_ get(Integer index) {
        return this.getAll().get(index);
    }

    public Document_ get(ObjectId id) {
        Document document = connexion.select(id, "Documents");
        Document_ Document = new Document_();
        Document.setIdDocument(document.getObjectId("_id"));
        Document.setDescriptionDocument(document.getString("Description"));
        Document.setPathDocument(document.getString("Path"));
        return Document;
    }
    public void add(ObjectId id, String description,String path) {
        Document_ document = new Document_(id, path, description);
        HashMap<String, Object> Infodocument = new HashMap<>();
        Infodocument.put("_id", document.getIdDocument());
        Infodocument.put("Description", document.getDescriptionDocument());
        Infodocument.put("Path", document.getPathDocument());
        connexion.insert(Infodocument, "Documents");
    }
    
    public void delete(ObjectId id, String key) {
        connexion.remove(id, key, "Documents");
    }

    public void delete(ObjectId id) {
        connexion.remove(id, "Documents");
    }
}