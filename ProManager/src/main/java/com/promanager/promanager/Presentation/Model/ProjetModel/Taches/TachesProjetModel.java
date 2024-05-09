package com.promanager.promanager.Presentation.Model.ProjetModel.Taches;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;

public class TachesProjetModel {
    private gestionProjet gProj;
    private gestionTache gTache;

    public TachesProjetModel() {
        gProj = new gestionProjet();
        gTache = new gestionTache();
    }

    public Projet getProjet(ObjectId idProj) {
        return gProj.get(idProj);
    }

    public Tache getTache(ObjectId idTache) {
        return gTache.get_Tache(idTache);
    }

    public void updateProjet(ObjectId idProj,ArrayList<ObjectId> listTaches) {
        gProj.update(idProj, "Taches", listTaches);
    }
}