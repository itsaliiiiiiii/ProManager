package com.promanager.promanager;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.services.calendar.Calendar;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;

public class GoogleCalendarAuth {
    private static final String APPLICATION_NAME = "ProManager"; // Application name
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance(); // JSON factory
    private static final String TOKENS_DIRECTORY_PATH = "tokens"; // Directory to store OAuth tokens

    public static Credential getCredentials() throws Exception {
        String chemin="C:\\Users\\pc\\Desktop\\ProManager\\ProManager\\ProManager\\src\\main\\java\\com\\promanager\\promanager\\credentials.json";
        FileInputStream in = new FileInputStream(chemin);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JSON_FACTORY,
                new InputStreamReader(in));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                clientSecrets,
                Collections.singletonList("https://www.googleapis.com/auth/calendar.readonly") // Corrected
        )
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH))) // Token storage
                .setAccessType("offline") // Retain tokens across sessions
                .build();

        return new AuthorizationCodeInstalledApp(
                flow,
                new LocalServerReceiver.Builder()
                        .setPort(8080) // Local port for OAuth callback
                        .build())
                .authorize("user"); // Start OAuth flow
    }

    public static Calendar getCalendarService() throws Exception {
        Credential credential = getCredentials(); // Get OAuth credentials
        return new Calendar.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credential)
                .setApplicationName(APPLICATION_NAME) // Set the application name
                .build(); // Return Google Calendar service
    }
}
