package com.promanager.promanager.Persistance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.promanager.promanager.Metier.POJO.Seance;

public class DAOseance {
    Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");

    public ArrayList<Seance> getAll() {
        ArrayList<Seance> Seances = new ArrayList<>();
        FindIterable<Document> documents = connexion.selectAll("Taches");
        Seance seance;
        for (Document document : documents) {
            seance = new Seance();
            seance.setIdSeance(document.getObjectId("_id"));
            seance.setNote(document.getString("Note"));
            seance.setDateDepartSeance(document.getDate("DateDepart"));
            seance.setDateFinSeance(document.getDate("DateFin"));
            seance.setDescriptionSeance(document.getString("Description"));
            Seances.add(seance);
        }
        return Seances;
    }

    public Seance get(Integer index) {
        return this.getAll().get(index);
    }

    public Seance get(ObjectId id) {
        Document document = connexion.select(id, "Seances");
        Seance seance = new Seance();
        seance.setIdSeance(document.getObjectId("_id"));
        seance.setNote(document.getString("Note"));
        seance.setDateDepartSeance(document.getDate("DateDepart"));
        seance.setDateFinSeance(document.getDate("DateFin"));
        seance.setDescriptionSeance(document.getString("Description"));
        seance.setListeDocument((ArrayList<ObjectId>) document.getList("Documents", ObjectId.class));
        return seance;
    }

    public ObjectId add(String description, Date dateDepart, Date dateFin, String note) {
        Seance seance = new Seance(description, dateDepart, dateFin, "");
        HashMap<String, Object> InfoSeance = new HashMap<>();
        InfoSeance.put("Description", seance.getDescriptionSeance());
        InfoSeance.put("DateDepart", seance.getDateDepartSeance());
        InfoSeance.put("DateFin", seance.getDateFinSeance());
        InfoSeance.put("Note", "");
        InfoSeance.put("Documents", new ArrayList<>());
        return connexion.insert(InfoSeance, "Seances");
    }

    public void delete(ObjectId id, String key) {
        connexion.remove(id, key, "Seances");
    }

    public void delete(ObjectId id) {
        connexion.remove(id, "Seances");
    }

    public void update(ObjectId id, String key, Object value) {
        connexion.update(id, key, value, "Seances");
    }

    public void update(ObjectId id, String key, List<Object> value) {
        connexion.update(id, key, value, "Seances");
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        connexion.update(id, Objects, "Seances");
    }
}