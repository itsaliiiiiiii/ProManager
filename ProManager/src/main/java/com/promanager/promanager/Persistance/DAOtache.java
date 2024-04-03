package com.promanager.promanager.Persistance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.promanager.promanager.Metier.POJO.Tache;

public class DAOtache {
    Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");

    public ArrayList<Tache> getAll() {
        ArrayList<Tache> Taches = new ArrayList<>();
        FindIterable<Document> documents = connexion.selectAll("Taches");
        Tache tache;
        for (Document document : documents) {
            tache = new Tache();
            tache.setIdTache(document.getObjectId("_id"));
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

    public Tache get(ObjectId id) {
        Document document = connexion.select(id, "Documents");
        Tache tache = new Tache();
        tache.setIdTache(document.getObjectId("_id"));
        tache.setCategorieTache(document.getString("Categorie"));
        tache.setDateDepartTache(document.getDate("DateDepart"));
        tache.setDateFinTache(document.getDate("DateFin"));
        tache.setDescriptionTache(document.getString("Description"));
        return tache;
    }

    public void add(ObjectId id, String categorie, String description, Date dateDepart, Date dateFinTache) {
        Tache tache = new Tache(id, categorie, description, dateDepart, dateFinTache);
        HashMap<String, Object> InfoTache = new HashMap<>();
        InfoTache.put("_id", tache.getIdTache());
        InfoTache.put("Description", tache.getDescriptionTache());
        InfoTache.put("DateDepart", tache.getDateDepartTache());
        InfoTache.put("DateFin", tache.getDateFinTache());
        InfoTache.put("Categorie", tache.getCategorieTache());
        connexion.insert(InfoTache, "Taches");
    }

    public void delete(ObjectId id, String key) {
        connexion.remove(id, key, "Taches");
    }

    public void delete(ObjectId id) {
        connexion.remove(id, "Taches");
    }
}