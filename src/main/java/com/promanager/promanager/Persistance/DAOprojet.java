package com.promanager.promanager.Persistance;
import com.promanager.promanager.Persistance.Connexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.promanager.promanager.Metier.POJO.Projet;
import org.bson.types.ObjectId;

public class DAOprojet {

    Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");

    public ArrayList<Projet> getAll() {
        ArrayList<Projet> Projects = new ArrayList<>();
        FindIterable<Document> documents = connexion.selectAll("Projets");
        Projet projet;
        for (Document document : documents) {
            projet = new Projet();
            projet.setCategorieProjet(document.getString("Categorie"));
            projet.setDateDepartProjet(document.getDate("DateDepart"));
            projet.setDateFinProjet(document.getDate("DateFin"));
            projet.setDescriptionProjet(document.getString("Description"));
            projet.setIdProjet(document.getObjectId("Id"));
            projet.setTypeProjet(document.getString("Type"));
            Projects.add(projet);
        }
        return Projects;
    }

    public Projet get(Integer index) {
        return this.getAll().get(index);
    }

    public Projet get(String id) {
        Document document = connexion.select(id, "Projets");
        Projet projet = new Projet();
        projet.setCategorieProjet(document.getString("Categorie"));
        projet.setDateDepartProjet(document.getDate("DateDepart"));
        projet.setDateFinProjet(document.getDate("DateFin"));
        projet.setDescriptionProjet(document.getString("Description"));
        projet.setIdProjet(document.getObjectId("_id"));
        projet.setTypeProjet(document.getString("Type"));
        return projet;
    }
    public void Add(String categorie, String type, String description, Date debut, Date fin){
        Projet projet = new Projet(categorie,type,description,debut,fin);
        HashMap<String,Object> InfoProjet =new HashMap<>();
        InfoProjet.put("Categorie",projet.getCategorieProjet());
        InfoProjet.put("Type",projet.getTypeProjet());
        InfoProjet.put("Description",projet.getDescriptionProjet());
        InfoProjet.put("DateDebut",projet.getDateDepartProjet());
        InfoProjet.put("DateFin",projet.getDateFinProjet());
        connexion.insert(InfoProjet,"Projets");
    }
    public void Remove(ObjectId id,String ID){
        connexion.remove(id,ID,"Projets");
    }
    public void Remove(ObjectId id){
        connexion.remove(id, "Projets");
    }

}