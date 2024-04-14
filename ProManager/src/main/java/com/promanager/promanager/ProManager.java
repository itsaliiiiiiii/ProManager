package com.promanager.promanager;

import java.net.URL;

import javax.imageio.ImageIO;

import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.View.LoginPage;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ProManager extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DAOconfiguration config = new DAOconfiguration();
        if (config.getMail().equals("empty")) {
            LoginPage loginPageView = new LoginPage(stage);
            Scene scene = new Scene(loginPageView, 1300, 800);
            stage.setScene(scene);
        } else {
            ProjetsPage projetsPage = new ProjetsPage(stage, "tout", "tout");
            Scene projectsScene = new Scene(projetsPage, 1300, 800);
            stage.setScene(projectsScene);
        }
        stage.setResizable(false);
        stage.setTitle("ProManager");
        stage.show();

        // String imagePath = "Presentation/View/Logo/ProManager.jpeg";
        // if (System.getProperty("os.name").toLowerCase().contains("mac")) {
        //     setDockIcon(imagePath);
        // } else if (System.getProperty("os.name").toLowerCase().contains("win")) {
        //     setTaskbarIcon(imagePath);
        // }
    }

    // private void setDockIcon(String imagePath) {
    //     try {
    //         URL iconUrl = getClass().getResource(imagePath);
    //         javafx.scene.image.Image fxImage = new javafx.scene.image.Image(iconUrl.toString());
    //         java.awt.Image awtImage = SwingFXUtils.fromFXImage(fxImage, null);
    //         Taskbar.getTaskbar().setIconImage(awtImage);
    //     } catch (UnsupportedOperationException | SecurityException e) {
    //         System.err.println(e.getMessage());
    //     }
    // }

    // private void setTaskbarIcon(String imagePath) {
    //     try {
    //         URL iconUrl = getClass().getResource(imagePath);
    //         BufferedImage bufferedImage = ImageIO.read(iconUrl);
    //         SystemTray tray = SystemTray.getSystemTray();
    //         TrayIcon trayIcon = new TrayIcon(bufferedImage);
    //         tray.add(trayIcon);
    //     } catch (IOException | UnsupportedOperationException | SecurityException | AWTException e) {
    //         System.err.println(e.getMessage());
    //     }
    // }

    public static void main(String[] args) {
        launch();
    }
}