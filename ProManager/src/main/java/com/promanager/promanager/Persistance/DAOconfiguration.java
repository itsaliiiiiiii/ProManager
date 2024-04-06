package com.promanager.promanager.Persistance;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class DAOconfiguration {
    Connexion connexion;

    public DAOconfiguration() {
        connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");
    }

    public void check(String value, String key) {
        FindIterable<Document> document = connexion.selectAll("Configurations");
        if (document.iterator().hasNext()) {
            Object obj = document.first().get(key);
            if (obj instanceof ArrayList<?>) {
                ArrayList<?> arrayList = (ArrayList<?>) obj;
                for (Object element : arrayList) {
                    System.out.println(element.toString());
                }
            } else if (obj instanceof String) {
                System.out.println(obj.toString());
            } else {
                System.out.println("Unsupported data type for key: " + key);
            }
        } else {
            System.out.println("No documents found matching the query.");
        }
    }

}
