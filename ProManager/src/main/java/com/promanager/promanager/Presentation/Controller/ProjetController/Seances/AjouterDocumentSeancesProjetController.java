package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import java.io.File;

import com.promanager.promanager.Presentation.Model.ProjetModel.Seances.AjouterDocumentSeancesProjetModel;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.AffichageSeancesHistorique;
import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.Seances.AjouterDocumentSeancesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.IOException;

public class AjouterDocumentSeancesProjetController {
    private Button PrecedentButton;
    private Button Ajouter;
    private Button SelectionDocument;
    @SuppressWarnings("unused")
    private Text text;
    private Text nameDocument;
    private ObjectId idSeance;
    private ObjectId idProjet;
    private Stage stage;
    private File selectedFile;

    private TextArea Description;
    private AjouterDocumentSeancesProjetModel model;

    public AjouterDocumentSeancesProjetController(AjouterDocumentSeancesProjet view, ObjectId idSeance,
            ObjectId idProjet,
            Stage stage) {
        this.idProjet = idProjet;
        this.idSeance = idSeance;
        this.stage = stage;
        PrecedentButton = view.getPrecedentButton();
        Ajouter = view.getAjouter();
        Description = view.getDescription();
        SelectionDocument = view.getSelectionDocument();
        text = view.getText();
        nameDocument = view.getLabel();
        model = new AjouterDocumentSeancesProjetModel(this, idSeance);

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

    public TextArea getDescription() {
        return Description;
    }

    private void back() {
        AffichageSeancesHistorique seac = new AffichageSeancesHistorique(idSeance, idProjet, stage);
        Scene projectsScene = new Scene(seac, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}
