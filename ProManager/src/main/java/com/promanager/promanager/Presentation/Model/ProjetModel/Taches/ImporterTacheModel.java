package com.promanager.promanager.Presentation.Model.ProjetModel.Taches;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.ImporterTacheController;

public class ImporterTacheModel {
    private ImporterTacheController controller;

    public ImporterTacheModel(ImporterTacheController controller) {
        this.controller = controller;
    }

    public void initialize(String selectedEvent, ArrayList<Tache> taches, ObjectId idProjet, String categorie)
            throws ProjetExeption {
        if (selectedEvent != null) {
            String[] parts = selectedEvent.split("- ");
            Integer index = Integer.parseInt(parts[0]);

            Tache t = taches.get(index);
            t.setCategorieTache(categorie);

            System.out.println(t.getCategorieTache());

            gestionTache gTache = new gestionTache();
            gestionProjet gProjet = new gestionProjet();
            ObjectId id = gTache.add(t.getCategorieTache(), t.getDescriptionTache(), t.getDateDepartTache(),
                    t.getDateFinTache());

            ArrayList<ObjectId> TACHES = new ArrayList<>();
            TACHES = gProjet.get(idProjet).getListeTaches();
            TACHES.add(id);
            gProjet.update(idProjet, "Taches", TACHES);

            controller.openTachesProjet(idProjet);

        } else {
            System.out.println("Aucune tâche sélectionnée.");
        }
    }

}