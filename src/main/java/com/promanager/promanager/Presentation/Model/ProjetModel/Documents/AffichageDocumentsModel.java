package com.promanager.promanager.Presentation.Model.ProjetModel.Documents;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;

public class AffichageDocumentsModel {
    private gestionDocument gDocument;
    private gestionProjet gProjet;

    public AffichageDocumentsModel() {
        gDocument = new gestionDocument();
        gProjet = new gestionProjet();
    }

    public Projet getProjet(ObjectId idProjet) {
        return gProjet.get(idProjet);
    }
    
    public ArrayList<ObjectId> getDocumentsProjets(ObjectId idProjet) {
        return gProjet.get(idProjet).getListeDocument();
    }

    public void updateProjet(ObjectId idProj, ArrayList<ObjectId> listDoc) {
        gProjet.update(idProj, "Documents", listDoc);
    }

    public Document_ getDocument(ObjectId idDoc) {
        return gDocument.get(idDoc);
    }

    public ArrayList<Document_> getDocuProjet(ObjectId idProjet) {
        ArrayList<Document_> document_ = new ArrayList<>();
        for (ObjectId document : getDocumentsProjets(idProjet)) {
            document_.add(gDocument.get(document));
        }
        return document_;
    }
}