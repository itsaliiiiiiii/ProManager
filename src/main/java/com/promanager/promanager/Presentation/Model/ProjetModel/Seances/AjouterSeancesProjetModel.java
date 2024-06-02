package com.promanager.promanager.Presentation.Model.ProjetModel.Seances;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Projet;

public class AjouterSeancesProjetModel {
    private gestionProjet gProjet;
    private gestionSeance gSeance;

    public AjouterSeancesProjetModel() {
        gProjet = new gestionProjet();
        gSeance = new gestionSeance();
    }

    public Projet getProjet(ObjectId id) {
        return gProjet.get(id);
    }

    public void updateProject(ObjectId idProj, ArrayList<ObjectId> listeTaches) {
        gProjet.update(idProj, "Seances", listeTaches);

    }

    public ObjectId addSeance(String description,
            Date datedepart,
            Date datefin,
            String note) {
        return gSeance.add(description, datedepart, datefin, note);

    }
}