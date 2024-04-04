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
    }

    public gestionListe(DAOliste liste) {
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
        liste.add(nom, description);
    }

    public void delete(ObjectId id, String key) {
        liste.delete(id, key);
    }

    public void delete(ObjectId id) {
        liste.delete(id);
    }

    public void update(ObjectId id, String key, Object value) {
        liste.update(id, key, value);
    }

    public void update(ObjectId id, String key, List<Object> value) {
        liste.update(id, key, value);
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        liste.update(id, Objects);
    }
}
