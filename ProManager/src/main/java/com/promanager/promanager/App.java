package com.promanager.promanager;


import org.bson.types.ObjectId;

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
        // System.out.println(p.get(0));
        // System.out.println(p.get(1));
        
        
        p.Add("CATYGORIE", "TYPE", "hgjhgvjhbvjhgva", new Date(), new Date());

        //p.delete(p.get(new ObjectId("660c417b68aa02744a122aaf")).getIdProjet(),"Type");
    }
}