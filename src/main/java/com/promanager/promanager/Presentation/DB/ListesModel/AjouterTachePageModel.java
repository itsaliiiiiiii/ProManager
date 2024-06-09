package com.promanager.promanager.Presentation.DB.ListesModel;


import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.Gestion.gestionTache;

public class AjouterTachePageModel {
    private gestionListe gListe;
    private gestionTache gTache;

    public AjouterTachePageModel() {
        gListe = new gestionListe();
        gTache = new gestionTache();
    }

    public ObjectId ajouterTache(String categorie, String description, Date dateDepart, Date dateFin) throws ProjetExeption{
        if(categorie!=null && description!=null) {
          return gTache.add(categorie, description, dateDepart, dateFin);  
        }
        else {
            throw new ProjetExeption();
        }
        
    }
    
    public void  addListe(String nom, String description, ArrayList<ObjectId> listeTaches) throws ProjetExeption {
        if(nom!=null && description!=null) {
            gListe.add(nom, description, listeTaches); 
          }
          else {
              throw new ProjetExeption();
          }
        
    }
    
    public ArrayList<ObjectId> getTachesListe(ObjectId idListe) {
        return gListe.get(idListe).getListeTache();
    }

    public void updateListe(ObjectId idListe,ArrayList<ObjectId> listeTache) {
        gListe.update(idListe, "Taches", listeTache);
    }
}