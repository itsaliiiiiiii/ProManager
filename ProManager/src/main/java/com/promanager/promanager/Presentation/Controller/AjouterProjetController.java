package com.promanager.promanager.Presentation.Controller;

import com.promanager.promanager.Presentation.View.AjouterProjetPage;
import com.promanager.promanager.Presentation.View.ProjetsPage;

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
        
    }

}
