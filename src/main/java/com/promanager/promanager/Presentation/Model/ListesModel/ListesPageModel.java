package com.promanager.promanager.Presentation.Model.ListesModel;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;

public class ListesPageModel {
    private gestionListe gListe;
    private gestionProjet gProjet;
    private gestionTache gTache;

    public ListesPageModel() {
        gListe = new gestionListe();
        gProjet = new gestionProjet();
        gTache = new gestionTache();
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

    public Tache getTache(ObjectId id) {
        return gTache.get_Tache(id);
    }

    public void deleteListe(ObjectId idListe) {
        gListe.delete(idListe);
    }

    public ObjectId addTache(Tache tache) throws ProjetExeption{
        return gTache.add(tache.getCategorieTache(), tache.getDescriptionTache(), tache.getDateDepartTache(), tache.getDateFinTache());
    }
    
}