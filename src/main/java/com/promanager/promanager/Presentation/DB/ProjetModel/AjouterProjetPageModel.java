package com.promanager.promanager.Presentation.DB.ProjetModel;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;

public class AjouterProjetPageModel {

    public void AjouterProjet(String nom, String categorie, String type, LocalDate datedepart,
            LocalDate datefin, String description) throws ProjetExeption {
        if (nom != null &&
                categorie != null &&
                type != null &&
                datedepart != null &&
                datefin != null) {
            gestionProjet gProjet = new gestionProjet();
            gProjet.add(nom,
                    categorie,
                    type, description,
                    Date.from(Instant.from((datedepart).atStartOfDay(ZoneId.systemDefault()))),
                    Date.from(Instant.from((datefin).atStartOfDay(ZoneId.systemDefault()))));
        } else {
            throw new ProjetExeption();
        }
    }
}