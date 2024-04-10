package com.promanager.promanager.Presentation.Controller.ProjetController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.HashMap;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.TachesProjet;

public class TachesProjetController {
    private Button AjouterButton;
    private Button PrecedentButton;
    private ListView<HashMap<String, ObjectId>> ListTaches;

    public TachesProjetController(TachesProjet view, Stage stage, ObjectId id) {
        this.AjouterButton = view.getAjouterButton();
        this.PrecedentButton = view.getPrecedentButton();

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            AffichageProjet AjouterPage = new AffichageProjet(id, stage);
            AffichageProjet root = AjouterPage;
            Scene projectsScene = new Scene(root, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });

        // AjouterButton.setOnAction(event -> {
        //     HashMap<String, ObjectId> selectedItem = ListTaches.getSelectionModel().getSelectedItem();
        //     if (selectedItem != null) {
        //         for (String key : selectedItem.keySet()) {
        //             ObjectId selectedId = selectedItem.get(key);
        //             System.out.println("Selected ID: " + selectedId);
        //         }
        //     } else {
        //         System.out.println("No item selected.");
        //     }
        // });
    }
}
