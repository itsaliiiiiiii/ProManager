package com.promanager.promanager.Presentation.DB.ProjetModel;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;

public class ModifierProjetModel {
    private gestionProjet gProj;

    public ModifierProjetModel() {
        gProj = new gestionProjet();

    }

    public Projet getProjet(ObjectId id) {
        return gProj.get(id);
    }

    public void modifierProjet(ObjectId idproj, String nom, String categorie, String type, LocalDate datedebut,
            LocalDate datefin, String description) throws ProjetExeption {
        if (nom != null &&
                categorie != null &&
                type != null &&
                datedebut != null &&
                datefin != null) {
            gestionProjet gProjet = new gestionProjet();
            gProjet.update(
                    idproj, nom,
                    categorie,
                    type,
                    description.equals(null) ? "--vide--" : description,
                    Date.from(Instant.from((datedebut).atStartOfDay(ZoneId.systemDefault()))),
                    Date.from(Instant.from((datefin).atStartOfDay(ZoneId.systemDefault()))),
                    (gProjet.get(idproj)).getListeTaches(),
                    (gProjet.get(idproj)).getListeSeances(),
                    (gProjet.get(idproj)).getListeDocument());
        } else {
            throw new ProjetExeption();
        }
    }
}