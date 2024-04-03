package com.promanager.promanager.Metier.Gestion;
import java.util.ArrayList;

import com.promanager.promanager.*;
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
    public void delete(){
        projet.remove();
    }
    
    
}
