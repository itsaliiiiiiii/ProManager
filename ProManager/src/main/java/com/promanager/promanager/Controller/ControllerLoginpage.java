package com.promanager.promanager.Controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.google.gson.Gson;

public class ControllerLoginpage {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField mail;

    @FXML
    private Text errorOutput;

    @FXML
    public void initialize() {
        try {
            File file = new File(
                    "/Users/its.aliiiiiiii/Desktop/Projects & Exercices/javaFX/ProManager/ProManager/src/main/java/com/promanager/promanager/Data/configuration.json");
            Reader reader = new FileReader(file);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            if (jsonObject.has("email") && !(jsonObject.get("email").getAsString()).equals("emptyMail")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/promanager/promanager/View/main.fxml"));
                Parent newRoot = loader.load();
                Stage stage = (Stage) someComponent.getScene().getWindow();
                stage.setScene(new Scene(newRoot, 1300, 800));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void verificationMail(ActionEvent event) {
        File file = new File(
                "/Users/its.aliiiiiiii/Desktop/Projects & Exercices/javaFX/ProManager/ProManager/src/main/java/com/promanager/promanager/Data/configuration.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String email = mail.getText();
        if (email.endsWith("@gmail.com")) {
            System.out.println("mail : " + email);
            try (Reader reader = new FileReader(file)) {
                JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

                if (jsonObject.has("email") && !(jsonObject.get("email").getAsString()).equals("emptyMail")) {
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/com/promanager/promanager/View/main.fxml"));
                        Parent newRoot = loader.load();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(newRoot, 1300, 800));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {

                        jsonObject.addProperty("email", email);
                        FileWriter writer = new FileWriter(file);
                        gson.toJson(jsonObject, writer);
                        System.out.println("Email value has been updated in the JSON file.");
                    } catch (IOException e) {

                    }
                }
            }
            // ------
        } else {
            errorOutput.setText("Adresse mail invalide.\nElle doit se terminer par  @gmail.com.");
            System.out.println("Adresse mail invalide. Elle doit se terminer par @gmail.com.");
        }
    }

}
