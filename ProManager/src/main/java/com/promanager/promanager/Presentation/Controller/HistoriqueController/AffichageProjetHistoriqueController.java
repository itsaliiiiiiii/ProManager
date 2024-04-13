package com.promanager.promanager.Presentation.Controller.HistoriqueController;

import com.promanager.promanager.Presentation.View.HistoriqueView.AffichageHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.AffichageProjetHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.TachesProjetHistorique;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ModifierProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageProjetHistoriqueController {
    private ObjectId idProjet;
    private Text nomProjetText;
    private Text categorieText;
    private Text typeText;
    private Text dateDepartText;
    private TextFlow textFlow;
    private Text dateFinText;

    private Button PrecedentButton;
    private Button documentsButton;
    private Button seancesButton;
    private Button tachesButton;
    private gestionProjet gProj;
    Stage stage;

    public AffichageProjetHistoriqueController(AffichageProjetHistorique view, Stage stage, ObjectId id) {
        this.idProjet = id;
        this.nomProjetText = view.getNomProjet();
        this.categorieText = view.getCategorie();
        this.typeText = view.getType();
        this.textFlow = view.getTextFlow();
        this.dateDepartText = view.getDateDepart();
        this.dateFinText = view.getDateFin();
        this.PrecedentButton = view.getPrecedentButton();
        this.documentsButton = view.getDocumentsButton();
        this.seancesButton = view.getSeancesButton();
        this.tachesButton = view.getTachesButton();
        this.gProj = new gestionProjet();
        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            openProjet();
        });

        tachesButton.setOnAction(event -> {
            openTachesProjet();
        });

        seancesButton.setOnAction(event -> {
            openSeancesProjet();
        });


    }

    private void openProjet() {
        AffichageHistorique projetsPage = new AffichageHistorique(stage, "tout", "tout");
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openSeancesProjet() {
        SeancesProjet projetsPage = new SeancesProjet(stage,idProjet);
        Scene projectsScene = new Scene(projetsPage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openTachesProjet() {
        TachesProjetHistorique tachesProjet = new TachesProjetHistorique(idProjet, stage);
        Parent tachesRoot = tachesProjet;
        Scene projectsScene = new Scene(tachesRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}