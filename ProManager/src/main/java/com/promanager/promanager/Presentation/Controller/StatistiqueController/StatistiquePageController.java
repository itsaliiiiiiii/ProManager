package com.promanager.promanager.Presentation.Controller.StatistiqueController;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatistiquePageController {
    private Stage stage;
    private Button Projets;
    private Button Listes;
    private Button Historiques;
    private Text nombresHeures;
    private gestionSeance gSeance;
    private ComboBox<Date> semaine;

    private HashMap<Date, Integer> Heures;

    public StatistiquePageController() {
        gSeance = new gestionSeance();
        Heures = new HashMap<>();
    }

    public StatistiquePageController(Stage stage, StatistiquePage view) {
        this.stage = stage;
        Listes = view.getListes();
        Historiques = view.getHistoriques();
        Projets = view.getProjets();
        gSeance = new gestionSeance();
        Heures = new HashMap<>();

        this.nombresHeures = view.getNombreHeures();
        semaine = view.getSemaine();

        semaine.setCellFactory(lv -> new DateListCell());
        semaine.setButtonCell(new DateListCell());

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
            if (hours != null) {
                nombresHeures.setText(hours.toString());
            } else {
                nombresHeures.setText("0");
            }
        });

        calcNombresHeures();
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

    public void calcNombresHeures() {
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
            Heures.put(currentWeekStart, (int) totalHoursThisWeek);
            semaine.getItems().add(currentWeekStart);
        }
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

    private Date findFirstMonday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateDepartetFin().get(0));
        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            cal.add(Calendar.DATE, -1);
        }
        return cal.getTime();
    }

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
}