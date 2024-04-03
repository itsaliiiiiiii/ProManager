package com.promanager.promanager.Persistance;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.promanager.promanager.Metier.POJO.Liste;

public class DAOliste {
    Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");

    public ArrayList<Liste> getAll() {
        ArrayList<Liste> listes = new ArrayList<>();
        FindIterable<Document> documents = connexion.selectAll("Listes");
        Liste liste;
        for (Document document : documents) {
            liste = new Liste();
            liste.setIdListe(document.getObjectId("_id"));
            liste.setDescriptionListe(document.getString("Description"));
            liste.setNomListe(document.getString("Nom"));
            listes.add(liste);
        }
        return listes;
    }

    public Liste get(Integer index) {
        return this.getAll().get(index);
    }

    public Liste get(ObjectId id) {
        Document document = connexion.select(id, "Listes");
        Liste liste = new Liste();
        liste.setIdListe(document.getObjectId("_id"));
        liste.setDescriptionListe(document.getString("Description"));
        liste.setNomListe(document.getString("Nom"));
        return liste;
    }

    public void add(ObjectId id, String nom, String description) {
        Liste liste = new Liste(id, nom, description);
        HashMap<String, Object> Infoliste = new HashMap<>();
        Infoliste.put("_id", liste.getIdListe());
        Infoliste.put("Description", liste.getDescriptionListe());
        Infoliste.put("Nom", liste.getNomListe());
        connexion.insert(Infoliste, "Listes");
    }

    public void delete(ObjectId id, String key) {
        connexion.remove(id, key, "Listes");
    }

    public void delete(ObjectId id) {
        connexion.remove(id, "Listes");
    }
}
