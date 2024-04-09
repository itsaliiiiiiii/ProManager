package com.promanager.promanager.Presentation.Controller.ProjetController;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;

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
    Stage stage ;

    public AffichageProjetController(AffichageProjet view, Stage stage) {
        this.idProjet = view.getIdProjet();
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
        this.stage = stage;

        
        PrecedentButton.setOnAction(event -> {
            openProjet();
        });
    }

    private void openProjet() {
        ProjetsPage projetsPage = new ProjetsPage(stage, "tout", "tout");
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(true);
        stage.setScene(projectsScene);
        stage.show();
    }
}
