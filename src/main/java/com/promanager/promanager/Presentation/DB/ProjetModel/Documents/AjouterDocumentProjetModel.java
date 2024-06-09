package com.promanager.promanager.Presentation.DB.ProjetModel.Documents;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Presentation.Controller.ProjetController.Documents.AjouterDocumentProjetController;


public class AjouterDocumentProjetModel {
    private gestionProjet gProjet;
    private gestionDocument gDocument;
    private AjouterDocumentProjetController controller;
    private ObjectId idProjet;

    public AjouterDocumentProjetModel(AjouterDocumentProjetController controller, ObjectId idProjet) {
        gProjet = new gestionProjet();
        gDocument = new gestionDocument();
        this.controller = controller;
        this.idProjet = idProjet;
    }

    public void stockerDocument(File selectedFile) throws IOException {
        Path destinationDirectory = Paths.get(getDocumentsDirectory());

        if (!Files.exists(destinationDirectory)) {
            try {
                Files.createDirectories(destinationDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path destinationFile = destinationDirectory.resolve(selectedFile.getName());
        Files.copy(selectedFile.toPath(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
        ArrayList<ObjectId> listDoc = new ArrayList<>();
        System.out.println(idProjet);
        listDoc = gProjet.get(idProjet).getListeDocument();
        ObjectId idDoc = gDocument.add(controller.getDescription().getText(), destinationFile.toString(), new Date());
        listDoc.add(idDoc);
        gProjet.update(idProjet, "Documents", listDoc);
    }

    private String getDocumentsDirectory() {
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