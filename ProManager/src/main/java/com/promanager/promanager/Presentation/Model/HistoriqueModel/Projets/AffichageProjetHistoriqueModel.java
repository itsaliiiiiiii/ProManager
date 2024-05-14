package com.promanager.promanager.Presentation.Model.HistoriqueModel.Projets;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;

public class AffichageProjetHistoriqueModel {
    private gestionProjet gProjet;

    public AffichageProjetHistoriqueModel() {
        gProjet = new gestionProjet();
    }
    
    public Projet getProjet(ObjectId idProjet) {
        return gProjet.get(idProjet);
    }
    
}