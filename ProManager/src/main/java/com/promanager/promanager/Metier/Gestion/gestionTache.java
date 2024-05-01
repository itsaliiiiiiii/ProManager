package com.promanager.promanager.Metier.Gestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Persistance.DAOtache;

public class gestionTache {
    private DAOtache tache;
    DAOconfiguration config;

    public gestionTache() {
        config = new DAOconfiguration();
        tache = new DAOtache();
    }

    public gestionTache(DAOtache tache) {
        config = new DAOconfiguration();
        this.tache = new DAOtache();
        this.tache = tache;
    }

    public ArrayList<Tache> getAll() {
        return tache.getAll();
    }

    public Tache get(Integer index) {
        return tache.get(index);
    }

    public Tache get_Tache(ObjectId id) {
        return tache.get(id);
    }

    public ObjectId add(String categorie, String description, Date dateDepart, Date dateFinTache)
            throws ProjetExeption {
        Date currentDate = new Date();
        if (categorie != null && dateDepart != null && dateFinTache != null && config.check(categorie, "Categorie")
                && (dateDepart.equals(currentDate) || dateDepart.after(currentDate))
                && (dateFinTache.after(dateDepart) || (dateFinTache.equals(dateDepart) && dateDepart.after(currentDate)))){
                return tache.add(categorie, description, dateDepart, dateFinTache, new ArrayList<ObjectId>());
        } else {
            throw new ProjetExeption();
        }
    }

    public void delete(ObjectId id, String key) {
        tache.delete(id, key);
    }

    public void delete(ObjectId id) {
        tache.delete(id);
    }

    public void update(ObjectId id, String key, Object value) {
        tache.update(id, key, value);
    }

    public void update(ObjectId id, String key, List<Object> value) {
        tache.update(id, key, value);
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        tache.update(id, Objects);
    }

    public void update(ObjectId id, String Categorie, String Description, Date debut, Date fin,
            ArrayList<ObjectId> Documents)
            throws ProjetExeption {
        Date currentDate = new Date();
        if (Categorie != null && Description != null && debut != null
                && fin != null && config.check(Categorie, "Categorie") &&
                (debut.equals(currentDate) || debut.after(currentDate)) &&
                fin.after(debut)) {
            tache.update(id, Categorie, Description, debut, fin, Documents);
        } else {
            throw new ProjetExeption();
        }
    }
}