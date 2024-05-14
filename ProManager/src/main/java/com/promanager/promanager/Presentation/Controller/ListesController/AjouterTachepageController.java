package com.promanager.promanager.Presentation.Controller.ListesController;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Liste;
import com.promanager.promanager.Presentation.Model.ListesModel.AjouterTachePageModel;
import com.promanager.promanager.Presentation.View.ListesView.AjouterTachePage;
import com.promanager.promanager.Presentation.View.ListesView.ListesPage;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AjouterTachepageController {
    private Text AjouterTache;
    private Text Categorie;
    private Text Description;
    private Text DateDepart;
    private Text DateFin;
    private TextArea InputDescription;
    private ComboBox<String> comboBoxCategorie;
    private Button buttonAnnuler;
    private Button buttonAjouter;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private TextField InputNomListe;
    private TextArea InputDescriptionListe;
    private RadioButton oldList;
    private RadioButton newList;
    private ToggleGroup toggleGroup;
    private ObjectId idListe;
    private AjouterTachePageModel model;

    private Stage stage;

    public AjouterTachepageController(AjouterTachePage view, Stage stage) {
        AjouterTache = view.getAjouterTache();
        Categorie = view.getCategorie();
        Description = view.getDescription();
        DateDepart = view.getDateDepart();
        DateFin = view.getDateFin();
        InputDescription = view.getInputDescription();
        this.comboBoxCategorie = view.getComboBoxCategorie();
        this.buttonAnnuler = view.getButtonAnnuler();
        this.buttonAjouter = view.getButtonAjouter();
        PickerDateDepart = view.getPickerDateDepart();
        PickerDateFin = view.getPickerDateFin();
        InputNomListe = view.getInputNomListe();
        InputDescriptionListe = view.getInputDescriptionListe();
        toggleGroup = view.getToggleGroup();
        idListe = view.getIdListe();
        oldList = view.getOldList();
        newList = view.getNewList();
        model = new AjouterTachePageModel();
        this.stage = stage;

        this.buttonAnnuler.setOnAction(event -> {
            openTachePage();
        });

    }

    public void AjouterTache(ObjectId idliiste) throws ProjetExeption {
        if (toggleGroup.getSelectedToggle() == null) {
            throw new ProjetExeption();
        } else if (toggleGroup.getSelectedToggle() == newList) {
            if (comboBoxCategorie.getSelectionModel().getSelectedItem() != null &&
                    PickerDateDepart.getValue() != null &&
                    PickerDateFin.getValue() != null) {

                ObjectId idtache = model.ajouterTache(comboBoxCategorie.getSelectionModel().getSelectedItem()
                                 ,InputDescription.getText()
                                 , Date.from(Instant.from((PickerDateDepart.getValue()).atStartOfDay(ZoneId.systemDefault())))
                                 , Date.from(Instant.from((PickerDateFin.getValue()).atStartOfDay(ZoneId.systemDefault())))
                    );

                ArrayList<ObjectId> listeTache = new ArrayList<ObjectId>();
                listeTache.add(idtache);

                model.addListe(InputNomListe.getText(), InputDescriptionListe.getText(), listeTache);
                
            } else {
                throw new ProjetExeption();
            }
        } else if (toggleGroup.getSelectedToggle() == oldList) {
            if (comboBoxCategorie.getSelectionModel().getSelectedItem() != null &&
                    PickerDateDepart.getValue() != null &&
                    PickerDateFin.getValue() != null) {
                ObjectId idtache = model.ajouterTache(comboBoxCategorie.getSelectionModel().getSelectedItem()
                        , InputDescription.getText()
                        , Date.from(Instant.from((PickerDateDepart
                        .getValue()).atStartOfDay(ZoneId.systemDefault())))
                        , Date.from(Instant.from((PickerDateFin
                        .getValue()).atStartOfDay(ZoneId.systemDefault())))
                        );
                
                ArrayList<ObjectId> listeTache = new ArrayList<ObjectId>();
                model.getTachesListe(idliiste).forEach(tache -> {
                    listeTache.add(tache);
                });

                listeTache.add(idtache);
                model.updateListe(idliiste, listeTache);

            } else {
                throw new ProjetExeption();
            }
        }
    }

    public void openTachePage() {
        ListesPage projetsPage = new ListesPage(stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}