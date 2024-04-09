package com.promanager.promanager.Presentation.Controller;

import com.promanager.promanager.Presentation.View.AjouterProjetPage;
import com.promanager.promanager.Presentation.View.ProjetsPage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ProjetsPageController {

    public AnchorPane background;
    private Button buttonAjouter;
    private Stage stage;

    public ProjetsPageController(ProjetsPage view, Stage stage) {
        this.background = view.getBack();
        this.buttonAjouter = view.getButtonAjouter();
        this.stage = stage;

        this.buttonAjouter.setOnAction(event -> {
            this.openAjouterProjet();
        });
    };

    private void openAjouterProjet() {
        AjouterProjetPage AjouterPage = new AjouterProjetPage(stage);
        Parent root = AjouterPage;
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}