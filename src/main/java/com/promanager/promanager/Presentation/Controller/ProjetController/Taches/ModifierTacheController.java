package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.ModifierTache;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Presentation.DB.ProjetModel.Taches.ModifierTacheModel;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.AjouterProjetPage;
import com.promanager.promanager.Presentation.View.ProjetView.ModifierProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class ModifierTacheController {
    private ObjectId idTache;
    private ObjectId idproj;
    private Text AjouterProjet;

    private Text Categorie;
    private ModifierTacheModel model;
    private Text Description;
    private Text DateDepart;
    private Text DateFin;
    private TextArea InputDescription;

    private ComboBox<String> comboBoxCategorie;
    private Button buttonAnnuler;
    private Button buttonModifier;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private Tache tache;
    private Stage stage;

    public ModifierTacheController(ModifierTache view, ObjectId id,ObjectId idTache, Stage stage) {
        this.idTache = idTache;
        this.idproj=id;
        AjouterProjet = view.getAjouterProjet();
        Categorie = view.getCategorie();
        Description = view.getDescription();
        DateDepart = view.getDateDepart();
        DateFin = view.getDateFin();
        InputDescription = view.getInputDescription();
        this.comboBoxCategorie = view.getComboBoxCategorie();
        this.buttonAnnuler = view.getButtonAnnuler();
        this.buttonModifier = view.getButtonModifier();
        PickerDateDepart = view.getPickerDateDepart();
        PickerDateFin = view.getPickerDateFin();
        model = new ModifierTacheModel();
        this.stage = stage;

        tache = model.getTache(idTache);
        comboBoxCategorie.setValue(tache.getCategorieTache());
        PickerDateDepart
                .setValue((tache.getDateDepartTache()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        PickerDateFin.setValue((tache.getDateFinTache()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        InputDescription.setText(tache.getDescriptionTache());

        this.buttonAnnuler.setOnAction(event -> {
            openAffichageProjet();
        });

        this.buttonModifier.setOnAction(event -> {
            try {
                modifierTache();
                openAffichageProjet();
            } catch (ProjetExeption e) {
                e.MessageErreurAjouterProjet();
            }
        });
    }

    private void modifierTache() throws ProjetExeption {
        if (comboBoxCategorie.getSelectionModel().getSelectedItem() != null &&
                PickerDateDepart.getValue() != null &&
                PickerDateFin.getValue() != null) {
            gestionTache gTache = new gestionTache();
            gTache.update(
                    idTache,comboBoxCategorie.getSelectionModel().getSelectedItem(),
                    InputDescription.getText().equals(null) ? "--vide--" : InputDescription.getText(),
                    Date.from(Instant.from((PickerDateDepart
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))),
                    Date.from(Instant.from((PickerDateFin
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))),
                    (gTache.get_Tache(idTache)).getListeDocument());
        } else {
            throw new ProjetExeption();
        }

    }

    private void openAffichageProjet() {
        TachesProjet projetsPage = new TachesProjet(idproj, stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}