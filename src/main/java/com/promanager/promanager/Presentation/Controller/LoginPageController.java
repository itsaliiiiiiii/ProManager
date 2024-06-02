package com.promanager.promanager.Presentation.Controller;

import com.promanager.promanager.Presentation.Model.LoginPageModel;
import com.promanager.promanager.Presentation.View.LoginPage;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPageController {
    LoginPageModel model;

    private TextField mailField;
    private Button loginButton;
    private Text errorOutputText;
    private Stage stage;

    public LoginPageController(LoginPage view, Stage stage) {
        this.mailField = view.getMailField();
        this.loginButton = view.getLoginButton();
        this.errorOutputText = view.getErrorOutputText();
        this.stage = stage;
        model = new LoginPageModel();
        this.loginButton.setOnAction(event -> {
            verificationMail();
        });
    }

    public void verificationMail() {
        String email = mailField.getText().trim();
        if (email.isEmpty()) {
            errorOutputText.setText("Veuillez saisir un Mail.");
        } else if (model.isGoogleMail(email)) {
            model.insertMail(email);
            openProjetsPage();
        } else {
            errorOutputText.setText("Veuillez saisir un Mail de Google.");
        }
    }

    private void openProjetsPage() {
        ProjetsPage projetsPage = new ProjetsPage(stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

}
