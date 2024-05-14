package com.promanager.promanager.Presentation.Controller.HistoriqueController.Taches;

import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.AffichageTacheHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.TachesProjetHistorique;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionTache;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageTacheHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;

    public AffichageTacheHistoriqueController(AffichageTacheHistorique view, Stage stage, ObjectId idTache, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            TachesProjetHistorique button = new TachesProjetHistorique(idProjet, stage);
            Scene projectsScene = new Scene(button, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });


    }

}
