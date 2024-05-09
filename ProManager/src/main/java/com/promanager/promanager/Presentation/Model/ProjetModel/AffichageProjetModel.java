package com.promanager.promanager.Presentation.Model.ProjetModel;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;

public class AffichageProjetModel {
    private gestionProjet gProjet;

    public AffichageProjetModel() {
        gProjet = new gestionProjet();
    }

    public Projet getProjet(ObjectId id) {
        return gProjet.get(id);
    }

    public void Cloner(ObjectId id) {
        gProjet.Cloner(id);
    }
    public void Cloturer(ObjectId id) {
        gProjet.update(id, "Status", "Termine");
    }

}