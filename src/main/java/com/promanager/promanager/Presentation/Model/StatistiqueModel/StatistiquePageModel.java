package com.promanager.promanager.Presentation.Model.StatistiqueModel;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;

public class StatistiquePageModel {
    private gestionSeance gSeance;
    private gestionProjet gProjet;
    public StatistiquePageModel(){
        gSeance = new gestionSeance();
        gProjet = new gestionProjet();
    }

    public ArrayList<Seance> getAllSeances(){
        return gSeance.getAll();
    }
    public ArrayList<Projet> getAllProjets(){
        return gProjet.getAll();
    }
    public Seance getSeance(ObjectId id){
        return gSeance.get(id);
    }
}