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
    private HashMap<Date, Integer> Heures;

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
        Heures = new HashMap<>();

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
            Integer hours = Heures.get(selectedValue);
            nombreHeuresSemaine.setText(hours.toString() + " Heures");
        });

        semaine.setCellFactory(lv -> new DateListCell());
        semaine.setButtonCell(new DateListCell());

        mois.setCellFactory(lv -> new MonthListCell());
        mois.setButtonCell(new MonthListCell());

        annee.setCellFactory(lv -> new YearListCell());
        annee.setButtonCell(new YearListCell());

        calcnombreHeuresSemaine();
        calcNombreHeuresMois();
        calcNombreHeuresAnnee();
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

    private ArrayList<Seance> getSeanceProjet() {
        ArrayList<Seance> seances = new ArrayList<>();
        ArrayList<Projet> projets = gProjet.getAll();
        for (Projet projet : projets) {
            ArrayList<ObjectId> seancesProjet = projet.getListeSeances();
            for (ObjectId seance_ : seancesProjet) {
                seances.add(gSeance.get(seance_));
            }
        }
        return seances;
    }

    // semaine --------------------------------------------------------------------
    public void calcnombreHeuresSemaine() {
        ArrayList<Seance> seances = gSeance.getAll();

        if (Heures == null) {
            Heures = new HashMap<>();
        }

        Date dateDepart = findFirstMonday();
        ArrayList<Date> dates = DateDepartetFin();
        if (dates.size() < 2) {
            return;
        }

        Date datefin = dates.get(1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateDepart);

        while (datefin.after(cal.getTime())) {
            Date currentWeekStart = cal.getTime();

            cal.add(Calendar.DATE, 6);
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
                Heures.put(currentWeekStart, (int) totalHoursThisWeek);
                semaine.getItems().add(currentWeekStart);
            }
        }
    }

    private Date findFirstMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateDepartetFin().get(0));
        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            cal.add(Calendar.DATE, -1);
        }
        return cal.getTime();
    }

    // semaine --------------------------------------------------------------------
    // mois -----------------------------------------------------------------------
    public void calcNombreHeuresMois() {
        ArrayList<Seance> seances = gSeance.getAll();
        if (Heures == null) {
            Heures = new HashMap<>();
        }

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM/yyyy");
        HashMap<String, Integer> monthlyHours = new HashMap<>();

        for (Seance seance : seances) {
            String monthKey = monthFormat.format(seance.getDateDepartSeance());
            long duration = seance.getDateFinSeance().getTime() - seance.getDateDepartSeance().getTime();
            int hours = (int) (duration / (1000 * 60 * 60));

            monthlyHours.put(monthKey, monthlyHours.getOrDefault(monthKey, 0) + hours);
        }

        mois.getItems().clear();
        monthlyHours.keySet().forEach(month -> {
            mois.getItems().add(parseMonth(month));
        });

        mois.setOnAction(event -> {
            String selectedMonth = monthFormat.format(mois.getValue());
            Integer hours = monthlyHours.get(selectedMonth);
            nombreHeuresMois.setText(hours + " Heures");
        });
    }

    private Date parseMonth(String month) {
        try {
            return new SimpleDateFormat("MM/yyyy").parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // mois -----------------------------------------------------------------------
    // Annee -----------------------------------------------------------------------
    public void calcNombreHeuresAnnee() {
        ArrayList<Seance> seances = gSeance.getAll();
        if (Heures == null) {
            Heures = new HashMap<>();
        }

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
    static class DateListCell extends ListCell<Date> {
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

    static class MonthListCell extends ListCell<Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");

        @Override
        protected void updateItem(Date item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(dateFormat.format(item));
            }
        }
    }

    static class YearListCell extends ListCell<Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");

        @Override
        protected void updateItem(Date item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(dateFormat.format(item));
            }
        }
    }

}