package com.promanager.promanager.Presentation.DB.ProjetModel;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.POJO.Tache;

public class AffichageProjetModel {
    private gestionProjet gProjet;
    private gestionSeance gSeance;
    private gestionTache gTache;
    private ObjectId idProjet;

    public AffichageProjetModel(ObjectId id) {
        gProjet = new gestionProjet();
        gSeance = new gestionSeance();
        gTache = new gestionTache();
        idProjet = id;
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

    public String nombreDocument(){
        ArrayList<ObjectId> seances = gProjet.get(idProjet).getListeSeances();
        ArrayList<ObjectId> taches = gProjet.get(idProjet).getListeTaches();

        int nbDoc = gProjet.get(idProjet).getListeDocument().size();
        
        for (ObjectId id : seances) {
            Seance seance = gSeance.get(id);
            nbDoc += seance.getListeDocument().size();
        }
        for (ObjectId id : taches) {
            Tache tache = gTache.get_Tache(id);
            nbDoc += tache.getListeDocument().size();
        }

        return " " + nbDoc;
    }

    public String nombreHeures() {
        ArrayList<ObjectId> seances = gProjet.get(idProjet).getListeSeances();
        int nbHeures = 0;
        for (ObjectId id : seances) {
            Seance seance = gSeance.get(id);
            long diff = seance.getDateFinSeance().getTime() - seance.getDateDepartSeance().getTime();
            int hours = (int) (diff / (60 * 60 * 1000));
            nbHeures += hours;
        }

        return " " + nbHeures;
    }

}