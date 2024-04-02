package com.promanager.promanager.Persistance;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Tache;

public class DAOtache {
    Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");

    public ArrayList<Tache> getAll() {
        ArrayList<Tache> Taches = new ArrayList<>();
        FindIterable<Document> documents = connexion.selectAll("Taches");
        Tache tache;
        for (Document document : documents) {
            tache = new Tache();
            tache.setIdTache(document.getString("_id"));
            tache.setCategorieTache(document.getString("Categorie"));
            tache.setDateDepartTache(document.getDate("DateDepart"));
            tache.setDateFinTache(document.getDate("DateFin"));
            tache.setDescriptionTache(document.getString("Description"));
            Taches.add(tache);
        }
        return Taches;
    }

    public Tache get(Integer index) {
        return this.getAll().get(index);
    }

    public Tache get(String id) {
        Document document = connexion.select(id, "Documents");
        Tache tache = new Tache();
        tache.setIdTache(document.getString("_id"));
        tache.setCategorieTache(document.getString("Categorie"));
        tache.setDateDepartTache(document.getDate("DateDepart"));
        tache.setDateFinTache(document.getDate("DateFin"));
        tache.setDescriptionTache(document.getString("Description"));
        return tache;
    }
}
