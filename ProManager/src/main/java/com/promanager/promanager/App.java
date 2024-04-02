package com.promanager.promanager;
<<<<<<< HEAD
import java.util.Date;

import javax.crypto.spec.PBEKeySpec;

import org.bson.types.ObjectId;
=======
>>>>>>> 4614fb6 (add files)

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
        DAOprojet p2=new DAOprojet();
=======
        // System.out.println(p.getAll());
        System.out.println("-----");
        // System.out.println(p.get(0));
        // System.out.println(p.get(1));
        
        
        p.Add("CATYGORIE", "TYPE", "First Project", new Date(), new Date());
        p2.Add("CATE","COUR", "JAVA", new Date(),new Date());
        //p.delete(p.get(new ObjectId("660c417b68aa02744a122aaf")).getIdProjet(),"Type");
=======

        System.out.println(p.get("660bc003555c28106bca39a1"));
>>>>>>> 4614fb6 (add files)
    }
}