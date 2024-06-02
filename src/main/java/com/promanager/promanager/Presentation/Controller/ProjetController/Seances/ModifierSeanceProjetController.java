package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;


import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Presentation.Model.ProjetModel.Seances.ModifierSeanceProjetModel;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.ModifierSeanceProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ModifierSeanceProjetController {
    private ModifierSeanceProjetModel model;
    private ObjectId idproj;
    private ObjectId idSeance;
    
    private TextArea InputDescription;
    private TextArea InputNote;

    private Button buttonAnnuler;
    private Button buttonModifier;
    private Seance seance;
    private Stage stage;

    public ModifierSeanceProjetController(ModifierSeanceProjet view, ObjectId id,ObjectId idSeance, Stage stage) {
        this.idproj = id;
        this.idSeance = idSeance;
        this.InputDescription = view.getInputDescription();
        this.InputNote = view.getInputNote();
        this.buttonAnnuler = view.getButtonAnnuler();
        this.buttonModifier = view.getButtonModifier();
        this.stage = stage;
        this.model = new ModifierSeanceProjetModel();


        seance = model.getSeance(this.idSeance);
        InputDescription.setText(seance.getDescriptionSeance());
        InputNote.setText(seance.getNote());

        this.buttonAnnuler.setOnAction(event -> {
                openSeancePages();
        });

        this.buttonModifier.setOnAction(event -> {
                model.modifierSeance(idSeance,InputDescription.getText(),InputNote.getText());
                openSeancePages();
        });
    }

    private void openSeancePages() {
        SeancesProjet projetsPage = new SeancesProjet(idproj, stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}
