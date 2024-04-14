package com.promanager.promanager.Presentation.Controller.HistoriqueController.Taches;

import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.AffichageTacheHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.TachesProjetHistorique;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import org.bson.types.ObjectId;

import com.promanager.promanager.Persistance.DAOprojet;

@SuppressWarnings("unused")
public class TachesProjetHistoriqueController {
    private Button PrecedentButton;
    private DAOprojet gProj;
    private Stage stage;

    public TachesProjetHistoriqueController(TachesProjetHistorique view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();
        gProj = new DAOprojet();
        this.stage = stage;
        PrecedentButton.setOnAction(event -> {
            AffichageProjetHistorique historiqueProjet = new AffichageProjetHistorique(id, stage);
            Scene projectsScene = new Scene(historiqueProjet, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });
    }

    public void openTache(ObjectId id, ObjectId idProjet) {
        AffichageTacheHistorique AjouterPage = new AffichageTacheHistorique(id, idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

}