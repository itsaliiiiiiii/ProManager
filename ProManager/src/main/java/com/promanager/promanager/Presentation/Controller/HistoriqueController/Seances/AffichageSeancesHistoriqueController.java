package com.promanager.promanager.Presentation.Controller.HistoriqueController.Seances;

import java.util.ArrayList;

import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.AffichageSeancesHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.SeancesProjetHistorique;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AffichageSeances;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AjouterDocumentSeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AffichageSeancesHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;
    private gestionSeance gSeance;

    public AffichageSeancesHistoriqueController(AffichageSeancesHistorique view, Stage stage, ObjectId idSeance, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        gSeance = new gestionSeance();

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
