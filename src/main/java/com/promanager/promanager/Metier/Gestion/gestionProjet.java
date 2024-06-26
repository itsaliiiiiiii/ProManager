package com.promanager.promanager.Metier.Gestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Persistance.DAOprojet;

public class gestionProjet {

    private DAOprojet projet;
    DAOconfiguration config;

    public gestionProjet() {
        projet = new DAOprojet();
        config = new DAOconfiguration();
    }
    
    public gestionProjet(DAOprojet projet) {
        projet = new DAOprojet();
        this.projet = projet;
    }

    public ArrayList<Projet> getAll() {
        return projet.getAll();
    }

    public Projet get(Integer index) {
        return projet.get(index);
    }

    public Projet get(ObjectId id) {
        return projet.get(id);
    }

    public void add(String nomProjet, String categorie, String type, String description, Date debut, Date fin)
            throws ProjetExeption {
        Date currentDate = new Date();
        if (nomProjet != null && categorie != null && type != null && description != null && debut != null
                && fin != null && config.check(categorie, "Categorie") &&
                config.check(type, "Type") &&
                (debut.equals(currentDate) || debut.after(currentDate)) &&
                fin.after(debut)) {
            projet.add(nomProjet, categorie, type, description, debut, fin);
        } else {
            throw new ProjetExeption();
        }
    }

    public void update(ObjectId id, String nomProjet, String categorie, String type, String description, Date debut,
            Date fin, ArrayList<ObjectId> Taches,
            ArrayList<ObjectId> Seances,
            ArrayList<ObjectId> Documents)
            throws ProjetExeption {
        Date currentDate = new Date();
        if (nomProjet != null && categorie != null && type != null && description != null && debut != null
                && fin != null && config.check(categorie, "Categorie") &&
                config.check(type, "Type") &&
                (debut.equals(currentDate) || debut.after(currentDate)) &&
                fin.after(debut)) {
            projet.update(id, nomProjet, categorie, type, description, debut, fin, Taches, Seances, Documents);
        } else {
            throw new ProjetExeption();
        }
    }

    public void Cloner(ObjectId id) {
        projet.Cloner(id);
    }

    public void update(ObjectId id, String key, Object value) {
        Date currentDate = new Date();
        if (key.equals("Description") || key.equals("Status")) {
            projet.update(id, key, value);
        } else if ((key.equals("Categorie") && config.check((String) value, "Categorie"))
                || (key.equals("Type") && config.check((String) value, "Type"))) {
            projet.update(id, key, value);
        } else if (key.equals("DateFin") && ((Date) value).after(currentDate)) {
            projet.update(id, key, value);
        }
    }

    public void update(ObjectId id, String key, List<ObjectId> value) {
        projet.update(id, key, value);
    }

    public Boolean CheckTache(ObjectId id) {
        ArrayList<Projet> projets = projet.getAll();
        for (Projet projet_ : projets) {
            if (projet_.getListeTaches().contains(id)) {
                return true;
            }
        }
        return false;
    }
}