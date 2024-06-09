package com.promanager.promanager.Presentation.DB.ProjetModel.Seances;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Seance;

public class AffichageSeancesModel {
    private gestionSeance gSeance;
    private gestionDocument gDocument;

    public AffichageSeancesModel() {
        gSeance = new gestionSeance();
        gDocument=new gestionDocument();
    }

    public Seance getSeance(ObjectId idSeance) {
        return gSeance.get(idSeance);
    }
    public Document_ getDocument(ObjectId idDocument) {return gDocument.get(idDocument);}

    public void updateSeance(ObjectId idSeance, ArrayList<ObjectId> listTaches) {
        gSeance.update(idSeance, "Documents", listTaches);
    }

}