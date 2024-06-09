package com.promanager.promanager.Presentation.DB.ProjetModel.Taches;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Tache;

public class ModifierTacheModel {
    private gestionTache gTache;

    public ModifierTacheModel() {
        gTache = new gestionTache();
    }

    public Tache getTache(ObjectId idTache) {
        Tache tache = gTache.get_Tache(idTache);
        return tache;
    }

}