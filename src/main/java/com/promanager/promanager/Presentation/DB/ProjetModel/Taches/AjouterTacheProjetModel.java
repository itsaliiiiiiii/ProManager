package com.promanager.promanager.Presentation.DB.ProjetModel.Taches;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Liste;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;

public class AjouterTacheProjetModel {
    private gestionProjet gProjet;
    private gestionListe gListe;
    private gestionTache gTache;
    private ArrayList<ObjectId> listeTaches;

    public AjouterTacheProjetModel() {
        gProjet = new gestionProjet();
        gTache = new gestionTache();
        listeTaches = new ArrayList<>();
        gListe = new gestionListe();
    }

    public Projet getProjet(ObjectId id) {
        return gProjet.get(id);
    }
    public ArrayList<Liste> getAllListe() {
        return gListe.getAll();
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

    public void addTacheToprojet(ObjectId idProj, ObjectId idTache) {
        listeTaches = gProjet.get(idProj).getListeTaches();
        listeTaches.add(idTache);
        gProjet.update(idProj, "Taches", listeTaches);
    }

    public Tache get_Tache(ObjectId idTache) {
        return gTache.get_Tache(idTache);
    }
}