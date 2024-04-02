package com.promanager.promanager;

import java.util.Date;

// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;

// import java.io.IOException;
// import java.util.Objects;

import com.promanager.promanager.Persistance.DAOprojet;

public class App {
    // @Override
    // public void start(Stage stage) throws IOException {

    // Parent root = FXMLLoader
    // .load(Objects.requireNonNull(getClass().getResource("Presentation/View/LoginPage.fxml")));
    // stage.setTitle("ProManager");
    // stage.setScene(new Scene(root, 1300, 800));
    // stage.setResizable(false);
    // stage.show();
    // }

    public static void main(String[] args) {
        // launch();
        DAOprojet p = new DAOprojet();
        // System.out.println(p.getAll());
        System.out.println("-----");
    
        Date d1 = new Date();
        Date d2 = new Date();
        // System.out.println(p.get(0));
        // System.out.println(p.get(1));
        //p.Add( "Encadrement", "COURS", "TATATTATATAT",d1,d2);
        //p.Remove(p.get("660c3c05e6bbaa76515a6285").getIdProjet(),"Type");
        //p.Remove(p.get("660c3c05e6bbaa76515a6285").getIdProjet());

    }
}