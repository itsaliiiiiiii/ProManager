package com.promanager.promanager.Presentation.Model.ListesModel;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;

public class ListesPageModel {
    private gestionListe gListe;
    private gestionProjet gProjet;

    public ListesPageModel() {
        gListe = new gestionListe();
        gProjet = new gestionProjet();
    }

    public ArrayList<ObjectId> getTachesListe(ObjectId idListe) {
        return gListe.get(idListe).getListeTache();
    }

    public void updateListe(ObjectId idListe, ArrayList<ObjectId> listeTache) {
        gListe.update(idListe, "Taches", listeTache);
    }

    public ArrayList<Projet> getAllProjets() {
        return gProjet.getAll();
    }

    public void deleteListe(ObjectId idListe) {
        gListe.delete(idListe);
    }
    
}