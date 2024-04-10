package com.promanager.promanager.Metier.Gestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOtache;

public class gestionTache {
    private DAOtache tache;

    
    public gestionTache() {
    }

    public gestionTache(DAOtache tache) {
        this.tache = tache;
    }
    public ArrayList<Tache> getAll(){
        return tache.getAll();
    }
    public Tache get(Integer index){
        return tache.get(index);
    }
    public Tache get_Tache(ObjectId id){
        return tache.get(id);
    }
    public void add(String categorie, String description, Date dateDepart, Date dateFinTache){
        tache.add(categorie,description,dateDepart,dateFinTache);
    }
    public void delete(ObjectId id,String key){
        tache.delete(id,key);
    }
    public void delete(ObjectId id){
        tache.delete(id);
    }
    public void update(ObjectId id, String key, Object value) {
        tache.update(id,key,value);
    }

    public void update(ObjectId id, String key, List<Object> value) {
        tache.update(id,key,value);
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        tache.update(id,Objects);
    }
}
