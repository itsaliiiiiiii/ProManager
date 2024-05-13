package com.promanager.promanager.Presentation.Model.ProjetModel.Taches;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Tache;

public class AffichageTachesModel {
    private gestionDocument gDoc;
    private gestionTache gTache;

    public AffichageTachesModel() {
        gDoc = new gestionDocument();
        gTache = new gestionTache();
    }

    public Document_ getDocument(ObjectId id) {
        return gDoc.get(id);
    }
    public Tache get_Tache(ObjectId id){
        return gTache.get_Tache(id);
    }
    public void updateTache(ObjectId idTache ,ArrayList<ObjectId> listTaches){
        gTache.update(idTache, "Documents", listTaches);

    }
}