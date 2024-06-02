package com.promanager.promanager.Presentation.Model.ProjetModel.Seances;

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
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.AjouterDocumentSeancesProjetController;

import javafx.scene.control.TextArea;

public class AjouterDocumentSeancesProjetModel {
    private ObjectId idSeance;
    private TextArea Description;

    public AjouterDocumentSeancesProjetModel(AjouterDocumentSeancesProjetController controller,ObjectId idSeance) {
        gDocument = new gestionDocument();
        gSeance = new gestionSeance();
        this.idSeance = idSeance;
        Description = controller.getDescription();

    }

    private gestionSeance gSeance;
    private gestionDocument gDocument;

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
        System.out.println(idSeance);
        listDoc = gSeance.get(idSeance).getListeDocument();
        ObjectId idDoc = gDocument.add(Description.getText(), destinationFile.toString(), new Date());
        listDoc.add(idDoc);
        gSeance.update(idSeance, "Documents", listDoc);
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