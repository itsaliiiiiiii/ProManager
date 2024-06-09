package com.promanager.promanager.Presentation.DB.HistoriqueModel.Seances;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;

public class SeancesProjetHistoriqueModel {
    private gestionProjet gProjet;
    private gestionSeance gSeance;

    public SeancesProjetHistoriqueModel() {
        gProjet = new gestionProjet();
        gSeance = new gestionSeance();
    }

    public Projet getProjet(ObjectId id) {
        return gProjet.get(id);
    }

    public Seance getSeance(ObjectId id) {
        return gSeance.get(id);
    }

    public void updateprojet(ObjectId idProjet, ArrayList<ObjectId> listSeances) {
        gProjet.update(idProjet, "Seances", listSeances);
    }
}