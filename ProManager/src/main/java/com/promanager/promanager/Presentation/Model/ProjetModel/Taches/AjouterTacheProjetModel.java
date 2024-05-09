package com.promanager.promanager.Presentation.Model.ProjetModel.Taches;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Tache;

public class AjouterTacheProjetModel {
    private gestionProjet gProjet;
    private gestionTache gTache;
    private ArrayList<ObjectId> listeTaches;
    

    public AjouterTacheProjetModel() {
        gProjet = new gestionProjet();
        gTache = new gestionTache();
                listeTaches = new ArrayList<>();

    }

    public void AjouterTacheProjet(ObjectId idProj, String categorie, LocalDate datedepart, LocalDate datefin,
            String desc) throws ProjetExeption {
        if (categorie != null &&
                datedepart != null &&
                datefin != null) {
            ObjectId id = gTache.add(
                    categorie, desc,
                    Date.from(Instant.from((datedepart).atStartOfDay(ZoneId.systemDefault()))),
                    Date.from(Instant.from((datefin).atStartOfDay(ZoneId.systemDefault()))));
            listeTaches = gProjet.get(idProj).getListeTaches();
            listeTaches.add(id);
            gProjet.update(idProj, "Taches", listeTaches);
        } else {
            throw new ProjetExeption();
        }
    }

    public void addTacheToprojet(ObjectId idProj,ObjectId idTache){
        listeTaches = gProjet.get(idProj).getListeTaches();
        listeTaches.add(idTache);
        gProjet.update(idProj, "Taches", listeTaches);
    }
    public Tache get_Tache(ObjectId idTache){
        return gTache.get_Tache(idTache);
    }
}