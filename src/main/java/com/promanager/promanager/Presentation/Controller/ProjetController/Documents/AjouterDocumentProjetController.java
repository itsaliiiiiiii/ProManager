package com.promanager.promanager.Presentation.Controller.ProjetController.Documents;

import java.io.File;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.DB.ProjetModel.Documents.AjouterDocumentProjetModel;
import com.promanager.promanager.Presentation.View.ProjetView.Documents.AffichageDocuments;
import com.promanager.promanager.Presentation.View.ProjetView.Documents.AjouterDocumentProjet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings("unused")
public class AjouterDocumentProjetController {
    private Button PrecedentButton;
    private Button Ajouter;
    private Button SelectionDocument;
    private Text text;
    private Text nameDocument;
    private ObjectId idProjet;
    private Stage stage;
    private File selectedFile;

    private TextArea Description;
    private AjouterDocumentProjetModel model;

    public TextArea getDescription() {
        return Description;
    }

    public AjouterDocumentProjetController(
            AjouterDocumentProjet view,
            Stage stage,
            ObjectId idProjet) {
        this.idProjet = idProjet;
        this.stage = stage;
        PrecedentButton = view.getPrecedentButton();
        Ajouter = view.getAjouter();
        Description = view.getDescription();
        SelectionDocument = view.getSelectionDocument();
        text = view.getText();
        nameDocument = view.getLabel();
        model = new AjouterDocumentProjetModel(this, idProjet);

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
                    model.stockerDocument(selectedFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                back();
            }
        });

    }

    private void back() {
        AffichageDocuments seac = new AffichageDocuments(idProjet, stage);
        Scene projectsScene = new Scene(seac, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}
