package com.promanager.promanager.Controller;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

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
    Boolean verificationMail(ActionEvent event) {

        String email = mail.getText();
        if (email.endsWith("@gmail.com")) {
            System.out.println("mail : " + email);

            // --------
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("nnn", email);
            String jsonString = gson.toJson(jsonObject);

            try (FileWriter writer = new FileWriter("configuration.json",true)) {
                writer.write(jsonString);
                System.out.println("JSON object has been written to the file.");
            } catch (IOException e) {
                System.err.println("Error writing JSON object to file: " + e.getMessage());
            }
            // ------
            // try {
            // FXMLLoader loader = new FXMLLoader();
            // loader.setLocation(getClass().getResource("/com/promanager/promanager/View/main.fxml"));
            // Parent newRoot = loader.load();
            // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // stage.setScene(new Scene(newRoot, 1300, 800));
            // } catch (IOException e) {
            // e.printStackTrace();
            // }
            return true;
        } else {
            errorOutput.setText("Adresse mail invalide.\nElle doit se terminer par  @gmail.com.");
            System.out.println("Adresse mail invalide. Elle doit se terminer par @gmail.com.");
            return false;
        }
    }

}
