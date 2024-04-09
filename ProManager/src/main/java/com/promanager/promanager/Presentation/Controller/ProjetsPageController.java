package com.promanager.promanager.Presentation.Controller;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.AffichageProjet;
import com.promanager.promanager.Presentation.View.AjouterProjetPage;
import com.promanager.promanager.Presentation.View.ProjetsPage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProjetsPageController {

    public AnchorPane background;
    private Button buttonAjouter;
    private ComboBox<String> CategorieFilter;
    private ComboBox<String> TypeFilter;
    private Button FiltrerButton;
    private Stage stage;

    public ProjetsPageController(ProjetsPage view, Stage stage) {
        this.background = view.getBack();
        this.buttonAjouter = view.getButtonAjouter();
        this.CategorieFilter = view.getCategorieFilter();
        this.TypeFilter = view.getTypeFilter();
        this.FiltrerButton = view.getFiltrerButton();
        this.stage = stage;

        this.buttonAjouter.setOnAction(event -> {
            this.openAjouterProjet();
        });

        this.FiltrerButton.setOnAction(event -> {
            this.filtrerProjets();
        });

    };

    private void openAjouterProjet() {
        stage.setWidth(1300);
        stage.setHeight(800);
        AjouterProjetPage AjouterPage = new AjouterProjetPage(stage);
        Parent root = AjouterPage;
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    private void filtrerProjets() {

        ProjetsPage projetsPage = new ProjetsPage(
                stage,
                TypeFilter.getSelectionModel().getSelectedItem() == null ? "tout"
                        : TypeFilter.getSelectionModel().getSelectedItem(),
                CategorieFilter.getSelectionModel().getSelectedItem() == null ? "tout"
                        : CategorieFilter.getSelectionModel().getSelectedItem());
        Parent root = projetsPage;
        Scene projectsScene = new Scene(root, stage.getWidth(), stage.getHeight());
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
    public void afficherProjet(ObjectId id){
        stage.setWidth(1300);
        stage.setHeight(800);
        AffichageProjet AjouterPage = new AffichageProjet(id);
        Parent root = AjouterPage;
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}