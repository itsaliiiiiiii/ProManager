package com.promanager.promanager.Persistance;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.promanager.promanager.Metier.POJO.Projet;

public class DAOprojet {

    Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");

    public ArrayList<Projet> getAll() {
        ArrayList<Projet> Projects = new ArrayList<>();
        FindIterable<Document> documents = connexion.selectAll("Projets");
        Projet projet;
        for (Document document : documents) {
            projet = new Projet();
            projet.setTypeProjet(document.getString("type"));
            Projects.add(projet);
        }
        return Projects;
    }

    public Projet get(Integer index) {
        return this.getAll().get(index);
    }

    public Projet get(String id) {
        Document document = connexion.select(id,"Projets");
        Projet projet = new Projet();
        projet.setTypeProjet(document.getString("type"));
        return projet;
    }
}