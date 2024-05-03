package com.promanager.promanager.Presentation.Controller.StatistiqueController;

import java.util.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.ListesVIiew.ListesPage;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.StatistiqueView.StatistiquePage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatistiquePageController {
    private Stage stage;
    private Button Projets;
    private Button Listes;
    private Button Historiques;
    private Text nombresHeures;
    private gestionSeance gSeance;

    public StatistiquePageController(Stage stage, StatistiquePage view) {
        this.stage = stage;
        Listes = view.getListes();
        Historiques = view.getHistoriques();
        Projets = view.getProjets();
        this.nombresHeures=view.getNombreHeures();


        this.Historiques.setOnAction(event -> {
            this.openHistoriquePage();
        });

        this.Listes.setOnAction(event -> {
            this.openListesPage();
        });
        this.Projets.setOnAction(event -> {
            this.openProjetPage();
        });
    }

    private void openHistoriquePage() {
        AffichageHistorique historiquePage = new AffichageHistorique(stage);
        Parent historiqueRoot = historiquePage;
        Scene projectsScene = new Scene(historiqueRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openListesPage() {
        ListesPage Listespage = new ListesPage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openProjetPage() {
        ProjetsPage Listespage = new ProjetsPage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
    private void calcNombresHeures(){
        
        HashMap<String,Integer> Heures =new HashMap<>();
        

        LocalDate firstMondayBeforeDate = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

    }
    private Date premierLundi(){
        ArrayList<Seance> Seances = gSeance.getAll();
        ArrayList<Date> dates = new ArrayList<>();
        for(Seance seance : Seances){
            dates.add(seance.getDateDepartSeance());
        }
        Collections.sort(dates);
        LocalDate firstMondayBeforeDate = (dates.get(0)).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return ;
    }



}