package com.promanager.promanager.Metier.Gestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Liste;
import com.promanager.promanager.Persistance.DAOliste;

public class gestionListe {
    private DAOliste liste;

    public gestionListe() {
        liste = new DAOliste();
    }
    
    public gestionListe(DAOliste liste) {
        liste = new DAOliste();
        this.liste = liste;
    }

    public ArrayList<Liste> getAll() {
        return liste.getAll();
    }

    public Liste get(Integer index) {
        return liste.get(index);
    }

    public Liste get(ObjectId id) {
        return liste.get(id);
    }

    public void add(String nom, String description) {
        if(nom.isEmpty()){
            System.out.println("Nom est vide");
            return;
        }
        liste.add(nom, description);
    }

    public void delete(ObjectId id, String key) {
        liste.delete(id, key);
    }

    public void delete(ObjectId id) {
        gestionProjet Gprojet;
        if ((liste.get(id).getListeTache()).size() == 0) {
            liste.delete(id);
        } else {
            Gprojet = new gestionProjet();
            for (ObjectId id_ : liste.get(id).getListeTache()) {
                if (!Gprojet.CheckTache(id_)) {
                    System.out.println("Liste contient des Taches");
                    return;
                }
            }
            liste.delete(id);
        }
    }

    public void update(ObjectId id, String key, Object value) {
        if (((String) value).isEmpty() && key.equals("Nom")) {
            System.out.println("Nom est vide");
            return;
        }
        liste.update(id, key, value);
    }

    public void update(ObjectId id, String key, List<Object> value) {
        liste.update(id, key, value);
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        liste.update(id, Objects);
    }
}