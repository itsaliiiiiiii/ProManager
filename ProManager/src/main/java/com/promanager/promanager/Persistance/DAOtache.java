package com.promanager.promanager.Persistance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
        Document document = connexion.select(id, "Taches");
        Tache tache = new Tache();
        tache.setIdTache(document.getObjectId("_id"));
        tache.setCategorieTache(document.getString("Categorie"));
        tache.setDateDepartTache(document.getDate("DateDepart"));
        tache.setDateFinTache(document.getDate("DateFin"));
        tache.setDescriptionTache(document.getString("Description"));
        return tache;
    }

    public void add(String categorie, String description, Date dateDepart, Date dateFinTache) {
        Tache tache = new Tache(categorie, description, dateDepart, dateFinTache);
        HashMap<String, Object> InfoTache = new HashMap<>();
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

    public void update(ObjectId id, String key, Object value) {
        connexion.update(id, key, value, "Taches");
    }

    public void update(ObjectId id, String key, List<Object> value) {
        connexion.update(id, key, value, "Taches");
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        connexion.update(id, Objects, "Taches");
    }
}