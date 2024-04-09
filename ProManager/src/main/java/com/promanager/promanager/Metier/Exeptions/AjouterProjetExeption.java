package com.promanager.promanager.Metier.Exeptions;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AjouterProjetExeption extends Exception {
    public void MessageErreurAjouterProjet() {
        Stage stage = new Stage();
        Label erreurMessage = new Label("Erreur Ajouter projet");
        Label message = new Label("An error occurred while adding the project.");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(erreurMessage, message,closeButton);
        Scene error = new Scene(root, 300, 300);

        stage.setScene(error);
        stage.setResizable(false);
        stage.setTitle("Erreur Ajouter projet");
        stage.show();
    }
}
