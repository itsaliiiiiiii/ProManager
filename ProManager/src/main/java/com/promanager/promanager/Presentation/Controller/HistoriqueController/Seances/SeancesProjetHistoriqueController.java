package com.promanager.promanager.Presentation.Controller.HistoriqueController.Seances;

import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.AffichageSeancesHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.SeancesProjetHistorique;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import org.bson.types.ObjectId;

public class SeancesProjetHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;

    public SeancesProjetHistoriqueController(SeancesProjetHistorique view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();
        this.stage = stage;
        PrecedentButton.setOnAction(event -> {
            AffichageProjetHistorique AjouterPage = new AffichageProjetHistorique(id, stage);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });
    }

    public void openSeance(ObjectId id, ObjectId idProjet) {
        AffichageSeancesHistorique AjouterPage = new AffichageSeancesHistorique(id, idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

}