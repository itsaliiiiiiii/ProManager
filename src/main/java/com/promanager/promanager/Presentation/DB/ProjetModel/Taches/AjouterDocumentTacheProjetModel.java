package com.promanager.promanager.Presentation.DB.ProjetModel.Taches;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionTache;

public class AjouterDocumentTacheProjetModel {

    private gestionTache gTache;
    private gestionDocument gDocument;

    public AjouterDocumentTacheProjetModel() {
        gTache = new gestionTache();
        gDocument = new gestionDocument();
    }

    public ArrayList<ObjectId> getListeDocument(ObjectId id) {
        return gTache.get_Tache(id).getListeDocument();
    }

    public void update(ObjectId idtache, ArrayList<ObjectId> listDoc) {
        gTache.update(idtache, "Documents", listDoc);
    }

    public ObjectId addDocument(String description, String destinationFile) {
        return gDocument.add(description, destinationFile, new Date());
    }

    public String getDocumentsDirectory() {
        String osName = System.getProperty("os.name").toLowerCase();
        String dic;
        if (osName.contains("mac")) {
            dic = System.getProperty("user.home") + "/Storage";
        } else if (osName.contains("win")) {
            dic = System.getProperty("user.home") + "\\Storage";
        } else {
            dic = System.getProperty("user.dir");
        }
        return dic;
    }

}