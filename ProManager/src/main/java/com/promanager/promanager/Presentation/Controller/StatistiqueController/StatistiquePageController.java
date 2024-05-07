package com.promanager.promanager.Presentation.Controller.StatistiqueController;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.ListesVIiew.ListesPage;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.StatistiqueView.StatistiquePage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatistiquePageController {
    private Stage stage;
    private Button Projets;
    private Button Listes;
    private Button Historiques;
    private gestionSeance gSeance;
    private gestionProjet gProjet;

    private ComboBox<Date> semaine;
    private Text nombreHeuresSemaine;

    private Text nombreHeuresMois;
    private ComboBox<Date> mois;

    private Text nombreHeuresAnnee;
    private ComboBox<Date> annee;

    private Text nombreHeuresSemaineCategorieEncadrement;
    private ComboBox<Date> semaineCategorieEncadrement;

    private Text nombreHeuresMoisCategorieEncadrement;
    private ComboBox<Date> moisCategorieEncadrement;

    private Text nombreHeuresAnneeCategorieEncadrement;
    private ComboBox<Date> anneeCategorieEncadrement;

    private Text nombreHeuresSemaineCategorieEnseignement;
    private ComboBox<Date> semaineCategorieEnseignement;

    private Text nombreHeuresMoisCategorieEnseignement;
    private ComboBox<Date> moisCategorieEnseignement;

    private Text nombreHeuresAnneeCategorieEnseignement;
    private ComboBox<Date> anneeCategorieEnseignement;

    private Text nombreHeuresSemaineTypePFA;
    private ComboBox<Date> semaineTypePFA;

    private Text nombreHeuresMoisTypePFA;
    private ComboBox<Date> moisTypePFA;

    private Text nombreHeuresAnneeTypePFA;
    private ComboBox<Date> anneeTypePFA;

    private Text nombreHeuresSemaineTypePFE;
    private ComboBox<Date> semaineTypePFE;

    private Text nombreHeuresMoisTypePFE;
    private ComboBox<Date> moisTypePFE;

    private Text nombreHeuresAnneeTypePFE;
    private ComboBox<Date> anneeTypePFE;

    private Text nombreHeuresSemaineTypeCours;
    private ComboBox<Date> semaineTypeCours;

    private Text nombreHeuresMoisTypeCours;
    private ComboBox<Date> moisTypeCours;

    private Text nombreHeuresAnneeTypeCours;
    private ComboBox<Date> anneeTypeCours;

    private Text nombreHeuresSemaineTypeExam;
    private ComboBox<Date> semaineTypeExam;

    private Text nombreHeuresMoisTypeExam;
    private ComboBox<Date> moisTypeExam;

    private Text nombreHeuresAnneeTypeExam;
    private ComboBox<Date> anneeTypeExam;

    public StatistiquePageController(Stage stage, StatistiquePage view) {
        this.stage = stage;
        Listes = view.getListes();
        Historiques = view.getHistoriques();
        Projets = view.getProjets();
        gSeance = new gestionSeance();
        gProjet = new gestionProjet();

        this.nombreHeuresSemaine = view.getNombreHeuresSemaine();
        semaine = view.getSemaine();

        this.nombreHeuresMois = view.getNombreHeuresMois();
        mois = view.getMois();

        this.nombreHeuresAnnee = view.getNombreHeuresAnnee();
        annee = view.getAnnee();

        this.nombreHeuresSemaineCategorieEncadrement = view.getNombreHeuresSemaineCategorieEncadrement();
        semaineCategorieEncadrement = view.getSemaineCategorieEncadrement();

        this.nombreHeuresMoisCategorieEncadrement = view.getNombreHeuresMoisCategorieEncadrement();
        moisCategorieEncadrement = view.getMoisCategorieEncadrement();

        this.nombreHeuresAnneeCategorieEncadrement = view.getNombreHeuresAnneeCategorieEncadrement();
        anneeCategorieEncadrement = view.getAnneeCategorieEncadrement();

        this.nombreHeuresSemaineCategorieEnseignement = view.getNombreHeuresSemaineCategorieEnseignement();
        semaineCategorieEnseignement = view.getSemaineCategorieEnseignement();

        this.nombreHeuresMoisCategorieEnseignement = view.getNombreHeuresMoisCategorieEnseignement();
        moisCategorieEnseignement = view.getMoisCategorieEnseignement();

        this.nombreHeuresAnneeCategorieEnseignement = view.getNombreHeuresAnneeCategorieEnseignement();
        anneeCategorieEnseignement = view.getAnneeCategorieEnseignement();

        this.nombreHeuresSemaineTypePFA = view.getNombreHeuresSemaineTypePFA();
        semaineTypePFA = view.getSemaineTypePFA();

        this.nombreHeuresMoisTypePFA = view.getNombreHeuresMoisTypePFA();
        moisTypePFA = view.getMoisTypePFA();

        this.nombreHeuresAnneeTypePFA = view.getNombreHeuresAnneeTypePFA();
        anneeTypePFA = view.getAnneeTypePFA();
        
        this.nombreHeuresSemaineTypePFE = view.getNombreHeuresSemaineTypePFE();
        semaineTypePFE = view.getSemaineTypePFE();

        this.nombreHeuresMoisTypePFE = view.getNombreHeuresMoisTypePFE();
        moisTypePFE = view.getMoisTypePFE();

        this.nombreHeuresAnneeTypePFE = view.getNombreHeuresAnneeTypePFE();
        anneeTypePFE = view.getAnneeTypePFE();

        this.nombreHeuresSemaineTypeCours = view.getNombreHeuresSemaineTypeCours();
        semaineTypeCours = view.getSemaineTypeCours();

        this.nombreHeuresMoisTypeCours = view.getNombreHeuresMoisTypeCours();
        moisTypeCours = view.getMoisTypeCours();

        this.nombreHeuresAnneeTypeCours = view.getNombreHeuresAnneeTypeCours();
        anneeTypeCours = view.getAnneeTypeCours();

        this.nombreHeuresSemaineTypeExam = view.getNombreHeuresSemaineTypeExam();
        semaineTypeExam = view.getSemaineTypeExam();

        this.nombreHeuresMoisTypeExam = view.getNombreHeuresMoisTypeExam();
        moisTypeExam = view.getMoisTypeExam();

        this.nombreHeuresAnneeTypeExam = view.getNombreHeuresAnneeTypeExam();
        anneeTypeExam = view.getAnneeTypeExam();

        this.Historiques.setOnAction(event -> {
            this.openHistoriquePage();
        });

        this.Listes.setOnAction(event -> {
            this.openListesPage();
        });
        this.Projets.setOnAction(event -> {
            this.openProjetPage();
        });

        this.semaine.setOnAction(event -> {
            Date selectedValue = semaine.getValue();
            Integer hours = HashMapSemaine("", "").get(selectedValue);
            nombreHeuresSemaine.setText(hours.toString() + " Heures");
        });

        this.mois.setOnAction(event -> {
            Date selectedValue = mois.getValue();
            Integer hours = HashMapMois("", "").get(selectedValue);
            nombreHeuresMois.setText(hours.toString() + " Heures");
        });

        this.annee.setOnAction(event -> {
            Date selectedValue = annee.getValue();
            Integer hours = HashMapAnnee("", "").get(selectedValue);
            nombreHeuresAnnee.setText(hours.toString() + " Heures");
        });

        semaine.setCellFactory(lv -> new DateListCellSemaine());
        semaine.setButtonCell(new DateListCellSemaine());

        mois.setCellFactory(lv -> new DateListCellMois());
        mois.setButtonCell(new DateListCellMois());

        annee.setCellFactory(lv -> new DateListCellAnnee());
        annee.setButtonCell(new DateListCellAnnee());

        fillDate(semaine, HashMapSemaine("", ""));
        fillDate(mois, HashMapMois("", ""));
        fillDate(annee, HashMapAnnee("", ""));
        // ---------
        this.semaineCategorieEncadrement.setOnAction(event -> {
            Date selectedValue = semaineCategorieEncadrement.getValue();
            Integer hours = HashMapSemaine("Categorie", "Encadrement").get(selectedValue);
            Integer Totalhours = HashMapSemaine("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresSemaineCategorieEncadrement.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresSemaineCategorieEncadrement.setText("0 %");
            }
        });

        this.moisCategorieEncadrement.setOnAction(event -> {
            Date selectedValue = moisCategorieEncadrement.getValue();
            Integer hours = HashMapMois("Categorie", "Encadrement").get(selectedValue);
            Integer Totalhours = HashMapMois("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresMoisCategorieEncadrement.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresMoisCategorieEncadrement.setText("0 %");
            }
        });

        this.anneeCategorieEncadrement.setOnAction(event -> {
            Date selectedValue = anneeCategorieEncadrement.getValue();
            Integer hours = HashMapAnnee("Categorie", "Encadrement").get(selectedValue);
            Integer Totalhours = HashMapAnnee("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresAnneeCategorieEncadrement.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresAnneeCategorieEncadrement.setText("0 %");
            }
        });

        semaineCategorieEncadrement.setCellFactory(lv -> new DateListCellSemaine());
        semaineCategorieEncadrement.setButtonCell(new DateListCellSemaine());

        moisCategorieEncadrement.setCellFactory(lv -> new DateListCellMois());
        moisCategorieEncadrement.setButtonCell(new DateListCellMois());

        anneeCategorieEncadrement.setCellFactory(lv -> new DateListCellAnnee());
        anneeCategorieEncadrement.setButtonCell(new DateListCellAnnee());

        fillDate(semaineCategorieEncadrement, HashMapSemaine("Categorie", "Encadrement"));
        fillDate(moisCategorieEncadrement, HashMapMois("Categorie", "Encadrement"));
        fillDate(anneeCategorieEncadrement, HashMapAnnee("Categorie", "Encadrement"));
        // ---------
        this.semaineCategorieEnseignement.setOnAction(event -> {
            Date selectedValue = semaineCategorieEnseignement.getValue();
            Integer hours = HashMapSemaine("Categorie", "Enseignement").get(selectedValue);
            Integer Totalhours = HashMapSemaine("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresSemaineCategorieEnseignement.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresSemaineCategorieEnseignement.setText("0 %");
            }
        });

        this.moisCategorieEnseignement.setOnAction(event -> {
            Date selectedValue = moisCategorieEnseignement.getValue();
            Integer hours = HashMapMois("Categorie", "Enseignement").get(selectedValue);
            Integer Totalhours = HashMapMois("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresMoisCategorieEnseignement.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresMoisCategorieEnseignement.setText("0 %");
            }
        });

        this.anneeCategorieEnseignement.setOnAction(event -> {
            Date selectedValue = anneeCategorieEnseignement.getValue();
            Integer hours = HashMapAnnee("Categorie", "Enseignement").get(selectedValue);
            Integer Totalhours = HashMapAnnee("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresAnneeCategorieEnseignement.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresAnneeCategorieEnseignement.setText("0 %");
            }
        });

        semaineCategorieEnseignement.setCellFactory(lv -> new DateListCellSemaine());
        semaineCategorieEnseignement.setButtonCell(new DateListCellSemaine());

        moisCategorieEnseignement.setCellFactory(lv -> new DateListCellMois());
        moisCategorieEnseignement.setButtonCell(new DateListCellMois());

        anneeCategorieEnseignement.setCellFactory(lv -> new DateListCellAnnee());
        anneeCategorieEnseignement.setButtonCell(new DateListCellAnnee());

        fillDate(semaineCategorieEnseignement, HashMapSemaine("Categorie", "Enseignement"));
        fillDate(moisCategorieEnseignement, HashMapMois("Categorie", "Enseignement"));
        fillDate(anneeCategorieEnseignement, HashMapAnnee("Categorie", "Enseignement"));
        // ----------------
        this.semaineTypePFA.setOnAction(event -> {
            Date selectedValue = semaineTypePFA.getValue();
            Integer hours = HashMapSemaine("Type", "PFA").get(selectedValue);
            Integer Totalhours = HashMapSemaine("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresSemaineTypePFA.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresSemaineTypePFA.setText("0 %");
            }
        });

        this.moisTypePFA.setOnAction(event -> {
            Date selectedValue = moisTypePFA.getValue();
            Integer hours = HashMapMois("Type", "PFA").get(selectedValue);
            Integer Totalhours = HashMapMois("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresMoisTypePFA.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresMoisTypePFA.setText("0 %");
            }
        });

        this.anneeTypePFA.setOnAction(event -> {
            Date selectedValue = anneeTypePFA.getValue();
            Integer hours = HashMapAnnee("Type", "PFA").get(selectedValue);
            Integer Totalhours = HashMapAnnee("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresAnneeTypePFA.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresAnneeTypePFA.setText("0 %");
            }
        });

        semaineTypePFA.setCellFactory(lv -> new DateListCellSemaine());
        semaineTypePFA.setButtonCell(new DateListCellSemaine());

        moisTypePFA.setCellFactory(lv -> new DateListCellMois());
        moisTypePFA.setButtonCell(new DateListCellMois());

        anneeTypePFA.setCellFactory(lv -> new DateListCellAnnee());
        anneeTypePFA.setButtonCell(new DateListCellAnnee());

        fillDate(semaineTypePFA, HashMapSemaine("Type", "PFA"));
        fillDate(moisTypePFA, HashMapMois("Type", "PFA"));
        fillDate(anneeTypePFA, HashMapAnnee("Type", "PFA"));
        // ----------------
        this.semaineTypePFE.setOnAction(event -> {
            Date selectedValue = semaineTypePFE.getValue();
            Integer hours = HashMapSemaine("Type", "PFE").get(selectedValue);
            Integer Totalhours = HashMapSemaine("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresSemaineTypePFE.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresSemaineTypePFE.setText("0 %");
            }
        });

        this.moisTypePFE.setOnAction(event -> {
            Date selectedValue = moisTypePFE.getValue();
            Integer hours = HashMapMois("Type", "PFE").get(selectedValue);
            Integer Totalhours = HashMapMois("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresMoisTypePFE.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresMoisTypePFE.setText("0 %");
            }
        });

        this.anneeTypePFE.setOnAction(event -> {
            Date selectedValue = anneeTypePFE.getValue();
            Integer hours = HashMapAnnee("Type", "PFE").get(selectedValue);
            Integer Totalhours = HashMapAnnee("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresAnneeTypePFE.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresAnneeTypePFE.setText("0 %");
            }
        });

        semaineTypePFE.setCellFactory(lv -> new DateListCellSemaine());
        semaineTypePFE.setButtonCell(new DateListCellSemaine());

        moisTypePFE.setCellFactory(lv -> new DateListCellMois());
        moisTypePFE.setButtonCell(new DateListCellMois());

        anneeTypePFE.setCellFactory(lv -> new DateListCellAnnee());
        anneeTypePFE.setButtonCell(new DateListCellAnnee());

        fillDate(semaineTypePFE, HashMapSemaine("Type", "PFE"));
        fillDate(moisTypePFE, HashMapMois("Type", "PFE"));
        fillDate(anneeTypePFE, HashMapAnnee("Type", "PFE"));
        // ----------------
        this.semaineTypeCours.setOnAction(event -> {
            Date selectedValue = semaineTypeCours.getValue();
            Integer hours = HashMapSemaine("Type", "Cours").get(selectedValue);
            Integer Totalhours = HashMapSemaine("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresSemaineTypeCours.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresSemaineTypeCours.setText("0 %");
            }
        });

        this.moisTypeCours.setOnAction(event -> {
            Date selectedValue = moisTypeCours.getValue();
            Integer hours = HashMapMois("Type", "Cours").get(selectedValue);
            Integer Totalhours = HashMapMois("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresMoisTypeCours.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresMoisTypeCours.setText("0 %");
            }
        });

        this.anneeTypeCours.setOnAction(event -> {
            Date selectedValue = anneeTypeCours.getValue();
            Integer hours = HashMapAnnee("Type", "Cours").get(selectedValue);
            Integer Totalhours = HashMapAnnee("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresAnneeTypeCours.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresAnneeTypeCours.setText("0 %");
            }
        });

        semaineTypeCours.setCellFactory(lv -> new DateListCellSemaine());
        semaineTypeCours.setButtonCell(new DateListCellSemaine());

        moisTypeCours.setCellFactory(lv -> new DateListCellMois());
        moisTypeCours.setButtonCell(new DateListCellMois());

        anneeTypeCours.setCellFactory(lv -> new DateListCellAnnee());
        anneeTypeCours.setButtonCell(new DateListCellAnnee());

        fillDate(semaineTypeCours, HashMapSemaine("Type", "Cours"));
        fillDate(moisTypeCours, HashMapMois("Type", "Cours"));
        fillDate(anneeTypeCours, HashMapAnnee("Type", "Cours"));
        // ----------------
        this.semaineTypeExam.setOnAction(event -> {
            Date selectedValue = semaineTypeExam.getValue();
            Integer hours = HashMapSemaine("Type", "Exam").get(selectedValue);
            Integer Totalhours = HashMapSemaine("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresSemaineTypeExam.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresSemaineTypeExam.setText("0 %");
            }
        });

        this.moisTypeExam.setOnAction(event -> {
            Date selectedValue = moisTypeExam.getValue();
            Integer hours = HashMapMois("Type", "Exam").get(selectedValue);
            Integer Totalhours = HashMapMois("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresMoisTypeExam.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresMoisTypeExam.setText("0 %");
            }
        });

        this.anneeTypeExam.setOnAction(event -> {
            Date selectedValue = anneeTypeExam.getValue();
            Integer hours = HashMapAnnee("Type", "Exam").get(selectedValue);
            Integer Totalhours = HashMapAnnee("", "").get(selectedValue);
            if (Totalhours != 0) { 
                double percentage = ((double) hours / Totalhours) * 100;
                nombreHeuresAnneeTypeExam.setText(String.format("%.2f %%", percentage));
            } else {
                nombreHeuresAnneeTypeExam.setText("0 %");
            }
        });

        semaineTypeExam.setCellFactory(lv -> new DateListCellSemaine());
        semaineTypeExam.setButtonCell(new DateListCellSemaine());

        moisTypeExam.setCellFactory(lv -> new DateListCellMois());
        moisTypeExam.setButtonCell(new DateListCellMois());

        anneeTypeExam.setCellFactory(lv -> new DateListCellAnnee());
        anneeTypeExam.setButtonCell(new DateListCellAnnee());

        fillDate(semaineTypeExam, HashMapSemaine("Type", "Exam"));
        fillDate(moisTypeExam, HashMapMois("Type", "Exam"));
        fillDate(anneeTypeExam, HashMapAnnee("Type", "Exam"));

    }

    private void fillDate(ComboBox<Date> elem, HashMap<Date, Integer> hash) {
        for (Date a : hash.keySet()) {
            if (hash.get(a) != null) {
                elem.getItems().add(a);
            }
        }
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

    private ArrayList<Date> DateDepartetFin() {
        ArrayList<Seance> seances = gSeance.getAll();
        ArrayList<Date> dates = new ArrayList<>();
        for (Seance seance : seances) {
            dates.add(seance.getDateDepartSeance());
        }
        Collections.sort(dates);
        ArrayList<Date> DateDepartFin = new ArrayList<>();
        DateDepartFin.add(dates.get(0));
        DateDepartFin.add(dates.get(dates.size() - 1));
        return DateDepartFin;
    }

    private ArrayList<Seance> getSeanceProjet(String key, String value) {
        ArrayList<Seance> seances = new ArrayList<>();
        ArrayList<Projet> projets = gProjet.getAll();

        for (Projet projet : projets) {
            if (key.equals("Categorie")) {
                if (projet.getCategorieProjet().equals(value)) {
                    ArrayList<ObjectId> seancesProjet = projet.getListeSeances();
                    for (ObjectId seance_ : seancesProjet) {
                        seances.add(gSeance.get(seance_));
                    }
                }
            } else if (key.equals("Type")) {
                if (projet.getTypeProjet().equals(value)) {
                    ArrayList<ObjectId> seancesProjet = projet.getListeSeances();
                    for (ObjectId seance_ : seancesProjet) {
                        seances.add(gSeance.get(seance_));
                    }
                }
            } else {
                ArrayList<ObjectId> seancesProjet = projet.getListeSeances();
                for (ObjectId seance_ : seancesProjet) {
                    seances.add(gSeance.get(seance_));
                }
            }
        }
        return seances;
    }

    // semaine ----------------------------------
    private HashMap<Date, Integer> HashMapSemaine(String key, String value) {
        HashMap<Date, Integer> heures = new HashMap<>();

        ArrayList<Seance> seances = getSeanceProjet(key, value);

        Date dateDepart = findFirstMonday();
        ArrayList<Date> dates = DateDepartetFin();

        Date datefin = dates.get(1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateDepart);

        while (datefin.after(cal.getTime())) {
            Date currentWeekStart = cal.getTime();

            cal.add(Calendar.DATE, 7);
            Date currentWeekEnd = cal.getTime();

            long totalHoursThisWeek = 0;
            for (Seance seance : seances) {
                Date seanceStart = seance.getDateDepartSeance();
                if (!seanceStart.before(currentWeekStart) && !seanceStart.after(currentWeekEnd)) {
                    long durationInMillies = seance.getDateFinSeance().getTime() - seanceStart.getTime();
                    totalHoursThisWeek += durationInMillies / (1000 * 60 * 60);
                }
            }
            if (totalHoursThisWeek != 0) {
                heures.put(currentWeekStart, (int) totalHoursThisWeek);
            }
        }

        return heures;
    }

    // mois ----------------------------------
    private HashMap<Date, Integer> HashMapMois(String key, String value) {
        HashMap<Date, Integer> heures = new HashMap<>();

        ArrayList<Seance> seances = getSeanceProjet(key, value);

        Date dateDepart = FirstDayOfThisMonth();
        ArrayList<Date> dates = DateDepartetFin();

        Date datefin = dates.get(1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateDepart);

        while (datefin.after(cal.getTime())) {
            Date currentWeekStart = cal.getTime();

            cal.add(Calendar.DATE, 31);
            Date currentWeekEnd = cal.getTime();

            long totalHoursThisWeek = 0;
            for (Seance seance : seances) {
                Date seanceStart = seance.getDateDepartSeance();
                if (!seanceStart.before(currentWeekStart) && !seanceStart.after(currentWeekEnd)) {
                    long durationInMillies = seance.getDateFinSeance().getTime() - seanceStart.getTime();
                    totalHoursThisWeek += durationInMillies / (1000 * 60 * 60);
                }
            }
            if (totalHoursThisWeek != 0) {
                heures.put(currentWeekStart, (int) totalHoursThisWeek);
            }
        }

        return heures;
    }

    // Annee -----------------------------------------------------------------------
    private HashMap<Date, Integer> HashMapAnnee(String key, String value) {
        HashMap<Date, Integer> heures = new HashMap<>();

        ArrayList<Seance> seances = getSeanceProjet(key, value);

        Date dateDepart = FirstDayOfThisYear();
        ArrayList<Date> dates = DateDepartetFin();

        Date datefin = dates.get(1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateDepart);

        while (datefin.after(cal.getTime())) {
            Date currentWeekStart = cal.getTime();

            cal.add(Calendar.DATE, 365);
            Date currentWeekEnd = cal.getTime();

            long totalHoursThisWeek = 0;
            for (Seance seance : seances) {
                Date seanceStart = seance.getDateDepartSeance();
                if (!seanceStart.before(currentWeekStart) && !seanceStart.after(currentWeekEnd)) {
                    long durationInMillies = seance.getDateFinSeance().getTime() - seanceStart.getTime();
                    totalHoursThisWeek += durationInMillies / (1000 * 60 * 60);
                }
            }
            if (totalHoursThisWeek != 0) {
                heures.put(currentWeekStart, (int) totalHoursThisWeek);
            }
        }

        return heures;
    }
    // ===========================================================================================

    private Date findFirstMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateDepartetFin().get(0));
        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            cal.add(Calendar.DATE, -1);
        }
        return cal.getTime();
    }

    private Date FirstDayOfThisMonth() {
        LocalDate firstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        return Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private Date FirstDayOfThisYear() {
        LocalDate firstDayOfYear = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
        return Date.from(firstDayOfYear.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    // -----------------------------------------------------------------------

    static class DateListCellSemaine extends ListCell<Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        protected void updateItem(Date item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(item);
                calendar.add(Calendar.DATE, 7);
                Date endDate = calendar.getTime();

                setText(dateFormat.format(item) + " - " + dateFormat.format(endDate));
            }
        }
    }

    static class DateListCellMois extends ListCell<Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        protected void updateItem(Date item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(item);
                calendar.add(Calendar.DATE, 31);
                Date endDate = calendar.getTime();

                setText(dateFormat.format(item) + " - " + dateFormat.format(endDate));
            }
        }
    }

    static class DateListCellAnnee extends ListCell<Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        protected void updateItem(Date item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(item);
                calendar.add(Calendar.DATE, 365);
                Date endDate = calendar.getTime();

                setText(dateFormat.format(item) + " - " + dateFormat.format(endDate));
            }
        }
    }
}