package com.promanager.promanager.Presentation.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;

import com.promanager.promanager.Persistance.Connexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@SuppressWarnings("unused")
public class ControllerLoginpage {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField mail;

    @FXML
    private Text errorOutput;

    @FXML
    public void initialize() {
        Connexion connexion = new Connexion("ProManagerDB", "mongodb://localhost:27017/");
    

        // connexion.insert("_id", "Configurations");
        // connexion.insert("alh", "alh");
        // connexion.insert("alh", 30);
        // ArrayList<String> d = new ArrayList<>();
        // HashMap<String, Object> hashmap = new HashMap<>();
        // connexion.remove("Configurations", "email");
        // connexion.insert("email", "ali@fff");
        connexion.close();
    }

    @FXML
    public void verificationMail(ActionEvent event) {
        String email = mail.getText();
        if (email.endsWith("@gmail.com")) {
            System.out.println("mail : " + email);
        }
    }
}