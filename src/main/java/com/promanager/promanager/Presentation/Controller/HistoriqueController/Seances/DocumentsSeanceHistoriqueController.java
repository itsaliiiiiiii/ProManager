package com.promanager.promanager.Presentation.Controller.HistoriqueController.Seances;

import java.io.File;

import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.AffichageSeancesHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.DocumentsSeanceHistorique;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionSeance;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class DocumentsSeanceHistoriqueController {
    private Button PrecedentButton;
    private Button SelectionDocument;
    private Text text;
    private Text nameDocument;
    private ObjectId idSeance;
    private ObjectId idProjet;
    private Stage stage;
    private File selectedFile;
    private TextArea Description;

    public DocumentsSeanceHistoriqueController(DocumentsSeanceHistorique view, ObjectId idSeance,
            ObjectId idProjet,
            Stage stage) {
        this.idProjet = idProjet;
        this.idSeance = idSeance;
        this.stage = stage;
        PrecedentButton = view.getPrecedentButton();
        Description = view.getDescription();
        SelectionDocument = view.getSelectionDocument();
        text = view.getText();
        nameDocument = view.getLabel();

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
