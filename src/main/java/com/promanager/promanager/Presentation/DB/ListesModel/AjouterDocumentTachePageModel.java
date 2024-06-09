package com.promanager.promanager.Presentation.DB.ListesModel;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionTache;

public class AjouterDocumentTachePageModel {
    private gestionTache gTache;
    private gestionDocument gDocument;

    public AjouterDocumentTachePageModel() {
        gTache = new gestionTache();
        gDocument = new gestionDocument();
    }
    public ArrayList<ObjectId> getListesDocuments(ObjectId idTache) {
        return gTache.get_Tache(idTache).getListeDocument();
    }

    public ObjectId addDocument(String description, String path, Date date) {
        return gDocument.add(description, path, date);
    }
    public void updateListeDocuments(ObjectId idTache, ArrayList<ObjectId> listTaches) {
        gTache.update(idTache, "Documents", listTaches);
    }
}