package com.promanager.promanager.Persistance;

import java.util.ArrayList;

import org.bson.Document;

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
            Document.setIdDocument(document.getString("_id"));
            Document.setDescriptionDocument(document.getString("Description"));
            Document.setPathDocument(document.getString("Path"));
            Documents.add(Document);
        }
        return Documents;
    }

    public Document_ get(Integer index) {
        return this.getAll().get(index);
    }

    public Document_ get(String id) {
        Document document = connexion.select(id, "Documents");
        Document_ Document = new Document_();
        Document.setIdDocument(document.getString("_id"));
        Document.setDescriptionDocument(document.getString("Description"));
        //Document.setPathDocument(document.getString("Path"));
        return Document;
    }
    
}