package com.promanager.promanager.Presentation.Controller.ProjetController;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
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
public class ModifierProjetController {
    private ObjectId idproj;
    private Text AjouterProjet;
    private Text NomProjet;
    private Text Type;
    private Text Categorie;
    private Text Description;
    private Text DateDepart;
    private Text DateFin;
    private TextField InputNomProjet;
    private TextArea InputDescription;
    private ComboBox<String> comboBoxType;
    private ComboBox<String> comboBoxCategorie;
    private Button buttonAnnuler;
    private Button buttonModifier;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private gestionProjet gProj;
    private Projet projet;
    private Stage stage;

    public ModifierProjetController(ModifierProjet view, ObjectId id, Stage stage) {
        this.idproj = id;
        AjouterProjet = view.getAjouterProjet();
        NomProjet = view.getNomProjet();
        Type = view.getType();
        Categorie = view.getCategorie();
        Description = view.getDescription();
        DateDepart = view.getDateDepart();
        DateFin = view.getDateFin();
        InputNomProjet = view.getInputNomProjet();
        InputDescription = view.getInputDescription();
        this.comboBoxType = view.getComboBoxType();
        this.comboBoxCategorie = view.getComboBoxCategorie();
        this.buttonAnnuler = view.getButtonAnnuler();
        this.buttonModifier = view.getButtonModifier();
        PickerDateDepart = view.getPickerDateDepart();
        PickerDateFin = view.getPickerDateFin();
        gProj = new gestionProjet();
        this.stage = stage;

        projet = gProj.get(id);
        InputNomProjet.setText(projet.getNomProjet());
        comboBoxCategorie.setValue(projet.getCategorieProjet());
        comboBoxType.setValue(projet.getTypeProjet());
        PickerDateDepart
                .setValue((projet.getDateDepartProjet()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        PickerDateFin.setValue((projet.getDateFinProjet()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        InputDescription.setText(projet.getDescriptionProjet());

        this.buttonAnnuler.setOnAction(event -> {
            openAffichageProjet();
        });

        this.buttonModifier.setOnAction(event -> {
            try {
                modifierProjet();
                openAffichageProjet();
            } catch (ProjetExeption e) {
                e.MessageErreurAjouterProjet();
            }
        });
    }

    private void modifierProjet() throws ProjetExeption {
        if (InputNomProjet.getText() != null &&
                comboBoxCategorie.getSelectionModel().getSelectedItem() != null &&
                comboBoxType.getSelectionModel().getSelectedItem() != null &&
                PickerDateDepart.getValue() != null &&
                PickerDateFin.getValue() != null) {
            gestionProjet gProjet = new gestionProjet();
            gProjet.update(
                    idproj, InputNomProjet.getText(),
                    comboBoxCategorie.getSelectionModel().getSelectedItem(),
                    comboBoxType.getSelectionModel().getSelectedItem(),
                    InputDescription.getText().equals(null) ? "--vide--" : InputDescription.getText(),
                    Date.from(Instant.from((PickerDateDepart
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))),
                    Date.from(Instant.from((PickerDateFin
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))),
                    (gProjet.get(idproj)).getListeTaches(),
                    (gProjet.get(idproj)).getListeSeances(),
                    (gProjet.get(idproj)).getListeDocument());
        } else {
            throw new ProjetExeption();
        }

    }

    private void openAffichageProjet() {
        AffichageProjet projetsPage = new AffichageProjet(idproj, stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}