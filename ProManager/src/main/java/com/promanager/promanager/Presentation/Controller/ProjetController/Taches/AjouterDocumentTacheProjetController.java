package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import java.io.File;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AffichageTaches;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AjouterDocumentTacheProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class AjouterDocumentTacheProjetController {
    private Button PrecedentButton;
    private Button Ajouter;
    private Button SelectionDocument;
    @SuppressWarnings("unused")
    private Text text;
    private Text nameDocument;
    private ObjectId idtache;
    private ObjectId idProjet;
    private Stage stage;
    private File selectedFile;
    private gestionTache gTache;
    private gestionDocument gDocument;
    private TextArea Description;

    public AjouterDocumentTacheProjetController(AjouterDocumentTacheProjet view, ObjectId idtache, ObjectId idProjet,
            Stage stage) {
        this.idProjet = idProjet;
        this.idtache = idtache;
        this.stage = stage;
        PrecedentButton = view.getPrecedentButton();
        Ajouter = view.getAjouter();
        Description = view.getDescription();
        gDocument = new gestionDocument();
        SelectionDocument = view.getSelectionDocument();
        text = view.getText();
        nameDocument = view.getLabel();
        gTache = new gestionTache();

        SelectionDocument.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Selectioner Document");
            selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                String[] path = selectedFile.getAbsolutePath().split("/");
                nameDocument.setText(path[path.length - 1]);
            }
        });

        PrecedentButton.setOnAction(event -> {
            back();
        });

        Ajouter.setOnAction(event -> {
            if (selectedFile != null) {
                try {
                    stockerDocument(selectedFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                back();
            }
        });

    }

    private void stockerDocument(File selectedFile) throws IOException {
        Path destinationDirectory = Paths.get("Storage");

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
        listDoc = gTache.get_Tache(idtache).getListeDocument();
        ObjectId idDoc = gDocument.add(Description.getText(), destinationFile.toString());
        listDoc.add(idDoc);
        gTache.update(idtache, "Documents", listDoc);
    }

    private void back() {
        AffichageTaches fficheTache = new AffichageTaches(idtache, idProjet, stage);
        Scene projectsScene = new Scene(fficheTache, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}
