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
            tache.setListeDocument((ArrayList<ObjectId>) document.getList("Documents", ObjectId.class));
            Taches.add(tache);
        }
        return Taches;
    }

    public Tache get(Integer index) {
        return this.getAll().get(index);
    }

    public Tache get(ObjectId id) {
        Document document = connexion.select(id, "Taches");
        if (document == null) {
            return null; 
        }
        Tache tache = new Tache();
        tache.setIdTache(document.getObjectId("_id"));
        tache.setCategorieTache(document.getString("Categorie"));
        tache.setDateDepartTache(document.getDate("DateDepart"));
        tache.setDateFinTache(document.getDate("DateFin"));
        tache.setDescriptionTache(document.getString("Description"));
        tache.setListeDocument((ArrayList<ObjectId>) document.getList("Documents", ObjectId.class));
        return tache;
    }

    public ObjectId add(String categorie, String description, Date dateDepart, Date dateFinTache,
            ArrayList<ObjectId> listDoc) {
        Tache tache = new Tache(categorie, description, dateDepart, dateFinTache);
        HashMap<String, Object> InfoTache = new HashMap<>();
        InfoTache.put("Description", tache.getDescriptionTache());
        InfoTache.put("DateDepart", tache.getDateDepartTache());
        InfoTache.put("DateFin", tache.getDateFinTache());
        InfoTache.put("Categorie", tache.getCategorieTache());
        InfoTache.put("Documents", listDoc);
        return connexion.insert(InfoTache, "Taches");
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

    public void update(ObjectId id, String Categorie, String Description, Date debut, Date fin,
            ArrayList<ObjectId> Documets) {
        HashMap<String, Object> InfoTache = new HashMap<>();
        InfoTache.put("Categorie", Categorie);
        InfoTache.put("Description", Description);
        InfoTache.put("DateDepart", debut);
        InfoTache.put("DateFin", fin);
        InfoTache.put("Documents", Documets);
        connexion.update(id, InfoTache, "Taches");
    }
}