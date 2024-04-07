package com.promanager.promanager.Presentation.Controller;

import com.promanager.promanager.Presentation.View.ProjetsPage;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

@SuppressWarnings("unused")

public class ProjetsPageController {

    public AnchorPane background;
    private Pane sideBar;
    private Button Projets;
    private Button Listes;
    private Button Historiques;
    private Button Statistiques;
    private Text ProjetsText;
    private ComboBox<String> CategorieFillter;
    private ComboBox<String> TypeFillter;
    private TextField rechercheInput;
    private Button rechercheButton;

    public ProjetsPageController(ProjetsPage view) {
        this.background = view.getBack();
        this.sideBar = view.getSideBar();
        this.Projets = view.getProjets();
        this.Listes = view.getListes();
        this.Historiques = view.getHistoriques();
        this.Statistiques = view.getStatistiques();
        this.ProjetsText = view.getProjetsText();
        this.CategorieFillter = view.getCategorieFilter();
        this.TypeFillter = view.getTypeFilter();
        this.rechercheInput = view.getRechercheInput();
        this.rechercheButton = view.getRechercheButton();
    }

}
