package com.promanager.promanager.Presentation.Model.ProjetModel.Seances;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;

public class ModifierSeanceProjetModel {
    private gestionProjet gProj;
    private gestionSeance gSeance;

    public ModifierSeanceProjetModel() {
        gProj = new gestionProjet();
        gSeance = new gestionSeance();

    }
    public Projet getProjet(ObjectId id) {
        return gProj.get(id);
    }

    public Seance getSeance(ObjectId idSeance) {
        return gSeance.get(idSeance);
    }

    public void modifierSeance(ObjectId idSeance,String description,String Note) {
            gSeance.update(idSeance, description, Note, gSeance.get(idSeance).getDateDepartSeance()
                    , gSeance.get(idSeance).getDateFinSeance()
                    , gSeance.get(idSeance).getListeDocument() );

    }
}
