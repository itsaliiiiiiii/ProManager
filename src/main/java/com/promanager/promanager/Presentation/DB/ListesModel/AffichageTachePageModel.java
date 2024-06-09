package com.promanager.promanager.Presentation.DB.ListesModel;

import java.util.ArrayList;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionTache;

public class AffichageTachePageModel {
    private gestionTache gTache;

    
    public AffichageTachePageModel(){
        gTache = new gestionTache();
    }

    public ArrayList<ObjectId> getListesDocuments(ObjectId idTache) {
        return gTache.get_Tache(idTache).getListeDocument();
    }

    public void updateListeDocuments(ObjectId idTache, ArrayList<ObjectId> listTaches) {
        gTache.update(idTache, "Documents", listTaches);
    }
}