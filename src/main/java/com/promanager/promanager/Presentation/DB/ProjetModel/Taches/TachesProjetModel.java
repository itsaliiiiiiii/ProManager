package com.promanager.promanager.Presentation.DB.ProjetModel.Taches;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
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

    public void updateProjet(ObjectId idProj, ArrayList<ObjectId> listTaches) {
        gProj.update(idProj, "Taches", listTaches);
    }

    public void clonerTache(ObjectId idTache, ObjectId idProjet) throws ProjetExeption {
        Tache tache = gTache.get_Tache(idTache);
        tache.setIdTache(new ObjectId());
        ObjectId idnewTache = gTache.add(tache.getCategorieTache(), tache.getDescriptionTache(),
                tache.getDateDepartTache(), tache.getDateFinTache());
        ArrayList<ObjectId> listTaches = gProj.get(idProjet).getListeTaches();
        listTaches.add(idnewTache);
        gProj.update(idProjet, "Taches", listTaches);
    }
}