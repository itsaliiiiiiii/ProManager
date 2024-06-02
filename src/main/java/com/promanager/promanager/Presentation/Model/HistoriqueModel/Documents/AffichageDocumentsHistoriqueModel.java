package com.promanager.promanager.Presentation.Model.HistoriqueModel.Documents;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;

public class AffichageDocumentsHistoriqueModel {
    private gestionDocument gDoc;
    private gestionProjet gProjet;
    public AffichageDocumentsHistoriqueModel() {
        gDoc = new gestionDocument();
        gProjet = new gestionProjet();
    }

    public Document_ getDocument(ObjectId idDoc) {
        return gDoc.get(idDoc);
    }

    public Projet getProjet(ObjectId idProj) {
        return gProjet.get(idProj);
    }
}
