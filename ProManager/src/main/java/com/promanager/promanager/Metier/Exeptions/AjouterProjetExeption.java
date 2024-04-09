package com.promanager.promanager.Metier.Exeptions;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AjouterProjetExeption extends Exception {
    public void MessageErreurAjouterProjet() {
        Stage stage = new Stage();
        Label erreurMessage = new Label("Erreur Ajouter projet");
        Label message = new Label(
                "Le nom ne peut pas être vide, la date de début doit être postérieure à aujourd'hui, la date de fin doit être postérieure à la date de début, et il est obligatoire de sélectionner une catégorie et un type pour le projet.");
        Button closeButton = new Button("OK");
        closeButton.setOnAction(event -> stage.close());

        VBox root = new VBox(20);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(erreurMessage, message, closeButton);
        Scene error = new Scene(root, 400, 200);

        erreurMessage.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-text-fill: red;");
        message.setStyle("-fx-font-size: 16px;");
        message.setWrapText(true);
        root.setStyle("-fx-background-color: #f0f0f0; -fx-alignment: center;");

        stage.setScene(error);
        stage.setResizable(false);
        stage.setTitle("Erreur Ajouter projet");
        stage.show();
    }
}
