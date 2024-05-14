package com.promanager.promanager.Presentation.Controller.HistoriqueController.Seances;

import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.AffichageSeancesHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.SeancesProjetHistorique;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionSeance;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageSeancesHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;

    public AffichageSeancesHistoriqueController(AffichageSeancesHistorique view, Stage stage, ObjectId idSeance, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            SeancesProjetHistorique AjouterPage = new SeancesProjetHistorique(idProjet, stage);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });


    }

}
