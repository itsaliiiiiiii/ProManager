package com.promanager.promanager.Presentation.DB.ProjetModel;

import java.util.ArrayList;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;

public class ProjetsPageModel {
    private gestionProjet gProjet;

    public ProjetsPageModel() {
        gProjet = new gestionProjet();
    }

    public ArrayList<Projet> getAllProjet() {

        return gProjet.getAll();
    }
}