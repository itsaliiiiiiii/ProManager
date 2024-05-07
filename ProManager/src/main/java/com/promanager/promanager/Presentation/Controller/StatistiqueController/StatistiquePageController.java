package com.promanager.promanager.Presentation.Controller.StatistiqueController;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        // this.annee.setOnAction(event -> {
        //     Date selectedValue = annee.getValue();
        //     Integer hours = HashMapAnnee("", "").get(selectedValue);
        //     nombreHeuresSemaine.setText(hours.toString() + " Heures");
        // });

        semaine.setCellFactory(lv -> new DateListCellSemaine());
        semaine.setButtonCell(new DateListCellSemaine());

        mois.setCellFactory(lv -> new DateListCellMois());
        mois.setButtonCell(new DateListCellMois());

        annee.setCellFactory(lv -> new DateListCellAnnee());
        annee.setButtonCell(new DateListCellAnnee());

        fillDate(semaine, HashMapSemaine("", ""));
        fillDate(mois, HashMapMois("", ""));
        // fillDate(annee, HashMapAnnee("", ""));

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

    // semaine ----------------------------------
    // mois ----------------------------------
    private HashMap<Date, Integer> HashMapMois(String key, String value) {
        HashMap<Date, Integer> heures = new HashMap<>();

        ArrayList<Seance> seances = getSeanceProjet(key, value);

        Date dateDepart = findFirstMonday();
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
            if (totalHoursThisWeek != 0 ) {
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

    // Annee -----------------------------------------------------------------------
    public void calcNombreHeuresAnnee() {
        ArrayList<Seance> seances = gSeance.getAll();
        

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        HashMap<String, Integer> yearlyHours = new HashMap<>();

        for (Seance seance : seances) {
            String yearKey = yearFormat.format(seance.getDateDepartSeance());
            long duration = seance.getDateFinSeance().getTime() - seance.getDateDepartSeance().getTime();
            int hours = (int) (duration / (1000 * 60 * 60));

            yearlyHours.put(yearKey, yearlyHours.getOrDefault(yearKey, 0) + hours);
        }

        annee.getItems().clear();
        yearlyHours.keySet().forEach(year -> {
            annee.getItems().add(parseYear(year));
        });

        annee.setOnAction(event -> {
            String selectedYear = yearFormat.format(annee.getValue());
            Integer hours = yearlyHours.get(selectedYear);
            nombreHeuresAnnee.setText(hours + " Heures");
        });
    }

    private Date parseYear(String year) {
        try {
            return new SimpleDateFormat("yyyy").parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Annee -----------------------------------------------------------------------
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
                calendar.add(Calendar.DATE, 30);
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