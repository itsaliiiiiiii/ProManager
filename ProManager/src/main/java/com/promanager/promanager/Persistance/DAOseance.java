package com.promanager.promanager.Persistance;

import java.util.ArrayList;

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
        return seance;
    }
}