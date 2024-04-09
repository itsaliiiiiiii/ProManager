package com.promanager.promanager.Persistance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.POJO.Tache;

public class DAOprojet {

    Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<Projet> getAll() {
        ArrayList<Projet> Projects = new ArrayList<>();
        FindIterable<Document> documents = connexion.selectAll("Projets");
        Projet projet;
        for (Document document : documents) {
            projet = new Projet();
            projet.setNomProjet(document.getString("Nom"));
            projet.setCategorieProjet(document.getString("Categorie"));
            projet.setDateDepartProjet(document.getDate("DateDebut"));
            projet.setDateFinProjet(document.getDate("DateFin"));
            projet.setDescriptionProjet(document.getString("Description"));
            projet.setIdProjet(document.getObjectId("_id"));
            projet.setTypeProjet(document.getString("Type"));
            projet.setListeTaches((ArrayList)document.getList("Taches", ObjectId.class));
            projet.setListeSeances((ArrayList)document.getList("Seances", ObjectId.class));
            projet.setListeDocument((ArrayList)document.getList("Documents", ObjectId.class));
            Projects.add(projet);
        }
        return Projects;
    }

    public Projet get(Integer index) {
        return this.getAll().get(index);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Projet get(ObjectId id) {
        Document document = connexion.select(id, "Projets");
        Projet projet = new Projet();
        projet.setNomProjet(document.getString("Nom"));
        projet.setCategorieProjet(document.getString("Categorie"));
        projet.setDateDepartProjet(document.getDate("DateDebut"));
        projet.setDateFinProjet(document.getDate("DateFin"));
        projet.setDescriptionProjet(document.getString("Description"));
        projet.setIdProjet(document.getObjectId("_id"));
        projet.setTypeProjet(document.getString("Type"));
        projet.setListeTaches((ArrayList) document.getList("Taches", Tache.class));
        projet.setListeSeances((ArrayList) document.getList("Seances", Seance.class));
        projet.setListeDocument((ArrayList) document.getList("Documents", Document_.class));

        return projet;
    }

    public void add(String nomProjet,String categorie, String type, String description, Date debut, Date fin) {
        Projet projet = new Projet(nomProjet,categorie, type, description, debut, fin);
        HashMap<String, Object> InfoProjet = new HashMap<>();
        InfoProjet.put("Nom", projet.getNomProjet());
        InfoProjet.put("Categorie", projet.getCategorieProjet());
        InfoProjet.put("Type", projet.getTypeProjet());
        InfoProjet.put("Description", projet.getDescriptionProjet());
        InfoProjet.put("DateDebut", projet.getDateDepartProjet());
        InfoProjet.put("DateFin", projet.getDateFinProjet());
        InfoProjet.put("Taches", new ArrayList<>());
        InfoProjet.put("Seances", new ArrayList<>());
        InfoProjet.put("Documents", new ArrayList<>());
        InfoProjet.put("Statut", "Ouvert");
        connexion.insert(InfoProjet, "Projets");
    }

    public void delete(ObjectId id, String key) {
        connexion.remove(id, key, "Projets");
    }

    public void delete(ObjectId id) {
        connexion.remove(id, "Projets");
    }

    public void update(ObjectId id, String key, Object value) {
        connexion.update(id, key, value, "Projets");
    }

    public void update(ObjectId id, String key, List<Object> value) {
        connexion.update(id, key, value, "Projets");
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        connexion.update(id, Objects, "Projets");
    }

}