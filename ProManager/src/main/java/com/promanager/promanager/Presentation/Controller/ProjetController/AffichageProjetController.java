package com.promanager.promanager.Presentation.Controller.ProjetController;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.ProjetView.TachesProjet;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageProjetController {
    private ObjectId idProjet;
    private Text nomProjetText;
    private Text categorieText;
    private Text typeText;
    private Text dateDepartText;
    private TextFlow textFlow;
    private Text dateFinText;
    private Button modifierButton;
    private Button clonerButton;
    private Button cloturerButton;
    private Button PrecedentButton;
    private Button documentsButton;
    private Button seancesButton;
    private Button tachesButton;
    Stage stage;

    public AffichageProjetController(AffichageProjet view, Stage stage, ObjectId id) {
        this.idProjet = id;
        this.nomProjetText = view.getNomProjet();
        this.categorieText = view.getCategorie();
        this.typeText = view.getType();
        this.textFlow = view.getTextFlow();
        this.dateDepartText = view.getDateDepart();
        this.dateFinText = view.getDateFin();
        this.modifierButton = view.getModifierButton();
        this.clonerButton = view.getClonerButton();
        this.cloturerButton = view.getClonerButton();
        this.PrecedentButton = view.getPrecedentButton();
        this.documentsButton = view.getDocumentsButton();
        this.seancesButton = view.getSeancesButton();
        this.tachesButton = view.getTachesButton();
        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            openProjet();
        });
        tachesButton.setOnAction(event -> {
            openTachesProjet();
        });
    }

    private void openProjet() {
        ProjetsPage projetsPage = new ProjetsPage(stage, "tout", "tout");
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openTachesProjet() {
        TachesProjet tachesProjet = new TachesProjet(idProjet, stage);
        Parent projetsRoot = tachesProjet;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}
