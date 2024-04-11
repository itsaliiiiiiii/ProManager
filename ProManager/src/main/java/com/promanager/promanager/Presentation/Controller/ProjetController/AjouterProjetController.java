package com.promanager.promanager.Presentation.Controller.ProjetController;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Presentation.View.ProjetView.AjouterProjetPage;
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
public class AjouterProjetController {
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
    private Button buttonAjouter;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private Stage stage;

    public AjouterProjetController(AjouterProjetPage view, Stage stage) {
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
        this.buttonAjouter = view.getButtonAjouter();
        PickerDateDepart = view.getPickerDateDepart();
        PickerDateFin = view.getPickerDateFin();
        this.stage = stage;

        this.buttonAnnuler.setOnAction(event -> {
            openProjetsPage();
        });

        this.buttonAjouter.setOnAction(event -> {
            try {
                AjouterProjet();
                openProjetsPage();
            } catch (ProjetExeption e) {
                e.MessageErreurAjouterProjet();
            }
        });
    }

    private void AjouterProjet() throws ProjetExeption {
        if (InputNomProjet.getText() != null &&
                comboBoxCategorie.getSelectionModel().getSelectedItem() != null &&
                comboBoxType.getSelectionModel().getSelectedItem() != null &&
                PickerDateDepart.getValue() != null &&
                PickerDateFin.getValue() != null) {
            gestionProjet gProjet = new gestionProjet();
            gProjet.add(InputNomProjet.getText(),
                    comboBoxCategorie.getSelectionModel().getSelectedItem(),
                    comboBoxType.getSelectionModel().getSelectedItem(), InputDescription.getText(),
                    Date.from(Instant.from((PickerDateDepart
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))),
                    Date.from(Instant.from((PickerDateFin
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))));
        } else {
            throw new ProjetExeption();
        }

    }

    private void openProjetsPage() {
        ProjetsPage projetsPage = new ProjetsPage(stage, "tout", "tout");
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}