package com.promanager.promanager.Presentation.Controller;

import com.promanager.promanager.Presentation.View.AjouterProjetPage;
import com.promanager.promanager.Presentation.View.ProjetsPage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private Button AjouterProjet;
    private Stage stage;

    public ProjetsPageController(ProjetsPage view,Stage stage) {
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
        this.AjouterProjet = view.getAjouterProjet();

        this.AjouterProjet.setOnAction(event -> {
            openAjouterProjet();
        });
    }
    private void openAjouterProjet(){
        AjouterProjetPage AjouterPage = new AjouterProjetPage(stage);
        System.out.println("dfghjxz");
        Parent root = AjouterPage;
        Scene AjouterPageScene = new Scene(root, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(true);
        stage.setScene(AjouterPageScene);
        stage.show();
    }

}
