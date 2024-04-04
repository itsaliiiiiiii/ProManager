package com.promanager.promanager.Metier.Gestion;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Persistance.DAOprojet;
public class gestionProjet {

    private DAOprojet projet;

    public gestionProjet() {
        projet = new DAOprojet();
    }

    public gestionProjet(DAOprojet projet) {
        this.projet = projet;
    }
    public ArrayList<Projet> getAll(){
        return projet.getAll();
    }
    public Projet get(Integer index){
        return projet.get(index);
    }
    public Projet get(ObjectId id){
        return projet.get(id);
    }
    public void add(String categorie, String type, String description, Date debut, Date fin){
        projet.add(categorie,type,description,debut,fin);
    }
    public void delete(ObjectId id,String key){
        projet.delete(id,key);
    }
    public void delete(ObjectId id){
        projet.delete(id);
    }
    public void update(ObjectId id, String key, Object value) {
        projet.update(id,key,value);
    }

    public void update(ObjectId id, String key, List<Object> value) {
        projet.update(id,key,value);
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        projet.update(id,Objects);
    }
}
