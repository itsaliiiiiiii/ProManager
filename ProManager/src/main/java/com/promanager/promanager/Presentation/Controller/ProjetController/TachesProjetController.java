package com.promanager.promanager.Presentation.Controller.ProjetController;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.ProjetView.TachesProjet;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class TachesProjetController {
    private TachesProjet view;
    private Stage stage;
    private ObjectId id;

    public TachesProjetController(TachesProjet view, Stage stage, ObjectId id) {
        this.view = view;
        this.stage = stage;
        this.id = id;

        view.getAjouterButton().setOnAction(event -> handleAjouterButtonClick());
        view.getListTaches().getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    handleListViewSelectionChange(newValue);
                });
    }

    private void handleAjouterButtonClick() {
        HBox selectedItem = view.getListTaches().getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            for (Node elem : selectedItem.getChildren()) {
                if (elem instanceof Text) {
                    System.out.println(((Text) elem).getText());
                }
            }
        } else {
            System.out.println("No item selected.");
        }
    }

    private void handleListViewSelectionChange(HBox newValue) {
        System.out.println(newValue);
    }
}
