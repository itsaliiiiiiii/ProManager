package com.promanager.promanager.Metier.Service;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.io.IOException;

public class CalendarImportApp extends Application {

    private static final String APPLICATION_NAME = "ProManager";
    @SuppressWarnings("deprecation")
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "client_secret_532722710699-c2srsk45ebcha6v42bhcuc2bam7qk95i.apps.googleusercontent.com.json";

    private static Credential authorize() throws GeneralSecurityException, IOException {
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JSON_FACTORY,
                new InputStreamReader(new FileInputStream(CREDENTIALS_FILE_PATH)));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                clientSecrets,
                Collections.singleton(CalendarScopes.CALENDAR_READONLY)).setAccessType("offline").build();

        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    @Override
    public void start(Stage primaryStage) {
        Button importButton = new Button("Import Calendar Events");
        TextArea eventDisplay = new TextArea();
        eventDisplay.setEditable(false); // Make the TextArea read-only

        importButton.setOnAction(e -> {
            try {
                Credential credential = authorize();
                Calendar service = new Calendar.Builder(
                        GoogleNetHttpTransport.newTrustedTransport(),
                        JSON_FACTORY,
                        credential).setApplicationName(APPLICATION_NAME).build();

                Calendar.Events.List request = service.events().list("primary");
                Events events = request.execute();

                StringBuilder sb = new StringBuilder();
                for (Event event : events.getItems()) {
                    sb.append(event.getSummary()).append("\n");
                }

                eventDisplay.setText(sb.toString());
            } catch (GeneralSecurityException | IOException ex) {
                ex.printStackTrace(); // Handle exceptions appropriately
            }
        });

        VBox vbox = new VBox(10, importButton, eventDisplay); // Layout with spacing
        Scene scene = new Scene(vbox, 400, 300);

        primaryStage.setTitle("Google Calendar Import");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
