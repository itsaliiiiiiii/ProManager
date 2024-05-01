package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import com.promanager.promanager.Presentation.View.ProjetView.Seances.AffichageSeances;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.ImporterSeance;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.ImporterTache;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Persistance.DAOprojet;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AjouterSeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;

public class SeancesProjetController {
    private Button PrecedentButton;
    private DAOprojet gProj;
    private Stage stage;

    public SeancesProjetController(SeancesProjet view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();
        gProj = new DAOprojet();
        this.stage = stage;
        PrecedentButton.setOnAction(event -> {
            AffichageProjet AjouterPage = new AffichageProjet(id, stage);
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
        AffichageSeances AjouterPage = new AffichageSeances(id, idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void supprimerSeanceProjet(ObjectId idProjet,ObjectId idSeance) {
        ArrayList<ObjectId> listSeances = gProj.get(idProjet).getListeSeances();
        listSeances.remove(idSeance);
        gProj.update(idProjet, "Seances", listSeances);

        SeancesProjet AjouterPage = new SeancesProjet(idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void AjouterTache(ObjectId idProjet){
        AjouterSeancesProjet AjouterPage = new AjouterSeancesProjet(idProjet,stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
    public void Importer(ObjectId idProjet) {
        ImporterSeance AjouterPage = new ImporterSeance(stage,idProjet);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}