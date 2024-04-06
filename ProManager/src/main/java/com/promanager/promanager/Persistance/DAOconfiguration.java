package com.promanager.promanager.Persistance;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class DAOconfiguration {
    Connexion connexion;

    public DAOconfiguration() {
        connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");
        connexion.insert("Type", Arrays.asList("PFE", "PFA", "Cours", "Exam"), "Configurations");
    }

    @SuppressWarnings("unchecked")
    public Boolean check(String value, String key) {
        FindIterable<Document> document = connexion.selectAll("Configurations");
        if (document.iterator().hasNext()) {
            Object obj = document.first().get(key);
            if (obj instanceof ArrayList<?>) {
                return ((ArrayList<String>) obj).contains(value);
            } else if (obj instanceof String) {
                return obj.toString().equals(value);
            }
        }
        return false;
    }
}