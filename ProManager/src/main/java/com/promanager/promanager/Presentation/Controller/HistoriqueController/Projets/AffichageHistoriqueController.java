package com.promanager.promanager.Presentation.Controller.HistoriqueController.Projets;

import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AffichageHistoriqueController {

    public AnchorPane background;
    private Button buttonProjets;
    private ComboBox<String> CategorieFilter;
    private ComboBox<String> TypeFilter;
    private Button FiltrerButton;
    private Stage stage;

    public AffichageHistoriqueController(AffichageHistorique view, Stage stage) {
        this.background = view.getBack();
        this.CategorieFilter = view.getCategorieFilter();
        this.TypeFilter = view.getTypeFilter();
        this.FiltrerButton = view.getFiltrerButton();
        this.stage = stage;
        this.buttonProjets = view.getProjets();

        this.FiltrerButton.setOnAction(event -> {
            this.filtrerProjets();
        });
        this.buttonProjets.setOnAction(event -> {
            this.openProjetsPage();
        });

    };

    private void filtrerProjets() {

        ProjetsPage projetsPage = new ProjetsPage(stage);
        Parent root = projetsPage;
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.show();
    }

    public void afficherProjet(ObjectId id) {
        stage.setWidth(1300);
        stage.setHeight(800);
        AffichageProjetHistorique historiquePage = new AffichageProjetHistorique(id, stage);
        Parent root = historiquePage;
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    private void openProjetsPage() {
        ProjetsPage projetsPage = new ProjetsPage(stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}