package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Presentation.DB.ProjetModel.Seances.AjouterSeancesProjetModel;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AjouterSeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouterSeancesProjetController {
    private Button Annule;
    private Button Ajouter;
    private Stage stage;
    private DatePicker PickerDate;
    private TextArea InputDescription;
    private TextField Note;
    
    private ComboBox<Integer> heurdebut;
    private ComboBox<Integer> heurfin;
    private ArrayList<ObjectId> listeTaches;
    @SuppressWarnings("unused")
    private String Proj;

    private AjouterSeancesProjetModel  model;

    private ObjectId idProj;

    public AjouterSeancesProjetController(AjouterSeancesProjet view, Stage stage, ObjectId idProj) {
        Annule = view.getButtonAnnuler();
        Ajouter = view.getButtonAjouter();
        PickerDate = view.getPickerDateDepart();
        InputDescription = view.getInputDescription();
        Note = view.getNote();
        heurdebut = view.getHeurdebut();
        heurfin = view.getHeurfin();
        listeTaches = new ArrayList<>();
        model = new AjouterSeancesProjetModel();

        this.Proj = model.getProjet(idProj).getNomProjet();

        this.idProj = idProj;
        this.stage = stage;
        Ajouter.setOnAction(event -> {
            try {
                AjouterTacheProjet();
                Back();
            } catch (ProjetExeption e) {
                e.MessageErreurAjouterProjet();
            }

        });
        Annule.setOnAction(event -> {
            Back();
        });
    }

    private void AjouterTacheProjet() throws ProjetExeption {
        if (PickerDate.getValue() != null &&
                !InputDescription.getText().isEmpty() &&
                heurdebut.getSelectionModel().getSelectedItem() != null &&
                heurfin.getSelectionModel().getSelectedItem() != null) {
            ObjectId id = model.addSeance(InputDescription.getText(),
                    DepartDateSeance(),
                    FinDateSeance(),
                    Note.getText());
            listeTaches = model.getProjet(idProj).getListeSeances();
            listeTaches.add(id);
            model.updateProject(idProj, listeTaches);
        } else {
            throw new ProjetExeption();
        }
    }

    private void Back() {
        SeancesProjet AjouterPage = new SeancesProjet(idProj, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void addTacheToProjet(ObjectId idTache) {
        listeTaches = model.getProjet(idProj).getListeSeances();
        listeTaches.add(idTache);
        model.updateProject(idProj, listeTaches);

        this.Back();
    }

    private Date DepartDateSeance() throws ProjetExeption {
        LocalDate selectedDate = PickerDate.getValue();
        Integer hour = heurdebut.getValue();

        if (selectedDate != null && hour != null) {
            LocalTime time = LocalTime.of(hour, 0);
            LocalDateTime dateTime = LocalDateTime.of(selectedDate, time);
            return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        } else {
            throw new ProjetExeption();
        }
    }

    private Date FinDateSeance() throws ProjetExeption {
        LocalDate selectedDate = PickerDate.getValue();
        Integer hour = heurfin.getValue();

        if (selectedDate != null && hour != null) {
            LocalTime time = LocalTime.of(hour, 0);
            LocalDateTime dateTime = LocalDateTime.of(selectedDate, time);
            return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        } else {
            throw new ProjetExeption();
        }
    }
}