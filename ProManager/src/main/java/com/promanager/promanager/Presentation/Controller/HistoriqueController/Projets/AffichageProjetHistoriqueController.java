package com.promanager.promanager.Presentation.Controller.HistoriqueController.Projets;

import com.promanager.promanager.Presentation.Model.HistoriqueModel.Projets.AffichageProjetHistoriqueModel;
import com.promanager.promanager.Presentation.View.HistoriqueView.Documents.AffichageDocumentsHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.SeancesProjetHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.TachesProjetHistorique;

import java.text.SimpleDateFormat;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageProjetHistoriqueController {
    private ObjectId idProjet;
    private Text nomProjetText;
    private Text categorieText;
    private Text typeText;
    private Text dateDepartText;
    private TextFlow textFlow;
    private Text dateFinText;

    private Button PrecedentButton;
    private Button documentsButton;
    private Button seancesButton;
    private Button tachesButton;
    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private Label desc;
    private Text dateFin;

    Stage stage;
    private AffichageProjetHistoriqueModel model;

    public AffichageProjetHistoriqueController(AffichageProjetHistorique view, Stage stage, ObjectId id) {
        this.idProjet = id;
        this.nomProjetText = view.getNomProjet();
        this.categorieText = view.getCategorie();
        this.typeText = view.getType();
        this.textFlow = view.getTextFlow();
        this.dateDepartText = view.getDateDepart();
        this.dateFinText = view.getDateFin();
        this.PrecedentButton = view.getPrecedentButton();
        this.documentsButton = view.getDocumentsButton();
        this.seancesButton = view.getSeancesButton();
        this.tachesButton = view.getTachesButton();
        model = new AffichageProjetHistoriqueModel();
        

        nomProjet = view.getNomProjet();
        categorie = view.getCategorie();
        type = view.getType();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        desc = view.getDesc();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            openProjet();
        });

        tachesButton.setOnAction(event -> {
            openTachesProjet();
        });

        seancesButton.setOnAction(event -> {
            openSeancesProjet();
        });
        documentsButton.setOnAction(event -> {
            openDocumentsProjet();
        });
        fillData();
        
    }

    private void fillData() {
        Projet projet = model.getProjet(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        nomProjet.setText("Nom Projet : " + projet.getNomProjet());
        categorie.setText("Categorie : " + projet.getCategorieProjet());
        type.setText("Type : " + projet.getTypeProjet());
        // Label desc = new Label(Projet.getDescriptionProjet());
        desc.setFont(new Font(15.0));
        // description.getChildren().add(desc);
        dateDepart.setText("Date Depart : " + sdf.format(projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(projet.getDateFinProjet()));
    }

    private void openProjet() {
        AffichageHistorique projetsPage = new AffichageHistorique(stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openSeancesProjet() {
        SeancesProjetHistorique projetsPage = new SeancesProjetHistorique(idProjet,stage);
        Scene projectsScene = new Scene(projetsPage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openTachesProjet() {
        TachesProjetHistorique tachesProjet = new TachesProjetHistorique(idProjet, stage);
        Parent tachesRoot = tachesProjet;
        Scene projectsScene = new Scene(tachesRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
    private void openDocumentsProjet(){
        AffichageDocumentsHistorique documentsProjet = new AffichageDocumentsHistorique(idProjet, stage);
        Parent documentsRoot = documentsProjet;
        Scene projectsScene = new Scene(documentsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}