package com.promanager.promanager.Metier.Gestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Persistance.DAOseance;

public class gestionSeance {
    private DAOseance seance;

    public gestionSeance() {
        seance = new DAOseance();
    }

    public gestionSeance(DAOseance seance) {
        this.seance = seance;
    }

    public ArrayList<Seance> getAll(){
        return seance.getAll();
    }
    public Seance get(Integer index){
        return seance.get(index);
    }
    public Seance get(ObjectId id){
        return seance.get(id);
    }
    public ObjectId add(String description, Date dateDepart, Date dateFin, String note){return seance.add(description, dateDepart, dateFin,"");}
    public void delete(ObjectId id,String key){
        seance.delete(id,key);
    }
    public void delete(ObjectId id){
        seance.delete(id);
    }
    public void update(ObjectId id, String key, Object value) {
        seance.update(id,key,value);
    }
    public void update(ObjectId id, String description, String note,Date Debut,Date Fin,ArrayList<ObjectId> Documents) {seance.update(id,description,Debut,Fin,note,Documents);}
    public void update(ObjectId id, String key, List<Object> value) {
        seance.update(id,key,value);
    }
    public void update(ObjectId id, HashMap<String, Object> Objects) {
        seance.update(id,Objects);
    }
}
