package com.promanager.promanager.Presentation.DB.ListesModel;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Tache;

public class ModifierTacheListeModel {
    private gestionTache gTache;

    public ModifierTacheListeModel() {
        gTache = new gestionTache();
    }

    public Tache getTache(ObjectId idTache) {
        return gTache.get_Tache(idTache);
    }

    public void modiferTache(ObjectId idTache,String categorie,String description,Date dateDepart,Date dateFin,ArrayList<ObjectId> listeDoc) throws ProjetExeption{
        gTache.update(idTache, categorie, description, dateDepart, dateFin, listeDoc);
    }
    
}