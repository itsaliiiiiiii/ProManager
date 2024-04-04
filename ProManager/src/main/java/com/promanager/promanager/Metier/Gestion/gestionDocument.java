package com.promanager.promanager.Metier.Gestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Persistance.DAOdocument;

public class gestionDocument {

    private DAOdocument document;

    public gestionDocument() {
        document = new DAOdocument();
    }

    public gestionDocument(DAOdocument document) {
        this.document = document;
    }

    public ArrayList<Document_> getAll() {
        return document.getAll();
    }

    public Document_ get(Integer index) {
        return document.get(index);
    }

    public Document_ get(ObjectId id) {
        return document.get(id);
    }

    public void add(String description, String path) {
        document.add(description, path);
    }

    public void delete(ObjectId id, String key) {
        document.delete(id, key);
    }

    public void delete(ObjectId id) {
        document.delete(id);
    }

    public void update(ObjectId id, String key, Object value) {
        document.update(id, key, value);
    }

    public void update(ObjectId id, String key, List<Object> value) {
        document.update(id, key, value);
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        document.update(id, Objects);
    }
}
