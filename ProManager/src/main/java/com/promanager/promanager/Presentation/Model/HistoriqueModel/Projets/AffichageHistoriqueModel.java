package com.promanager.promanager.Presentation.Model.HistoriqueModel.Projets;

import java.util.ArrayList;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;

public class AffichageHistoriqueModel {

    private gestionProjet gProjet;

    public AffichageHistoriqueModel() {
        gProjet = new gestionProjet();
    }

    public ArrayList<Projet> getAllProjets() {
        return gProjet.getAll();
    }
}