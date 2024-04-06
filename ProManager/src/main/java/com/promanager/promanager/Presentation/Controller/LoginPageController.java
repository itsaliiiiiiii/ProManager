package com.promanager.promanager.Presentation.Controller;

import com.promanager.promanager.Presentation.View.LoginPage;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginPageController {

    private TextField mailField;
    private Button loginButton;
    private Text errorOutputText;

    public LoginPageController(LoginPage view) {
        this.mailField = view.getMailField();
        this.loginButton = view.getLoginButton();
        this.errorOutputText = view.getErrorOutputText();

        this.loginButton.setOnAction(event -> {
            verificationMail();
        });
    }

    public void verificationMail() {
        String email = mailField.getText().trim();
        if (isValidEmail(email)) {
            errorOutputText.setText("Correct");
        } else {
            String errorMessage = getErrorMessage(email);
            errorOutputText.setText(errorMessage);
        }
    }

    private boolean isValidEmail(String email) {
        if (email.endsWith("@gmail.com")) {
            return true;
        } else {
            return false;
        }
    }

    private String getErrorMessage(String email) {
        if (email.isEmpty()) {
            return "Please enter your email address.";
        } else {
            return "Invalid email format.";
        }
    }
}
