package com.promanager.promanager.Metier.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.tasks.Tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
// import com.google.api.services.tasks.model.Task;
// import java.util.Collections;
// import java.util.List;

@SuppressWarnings({ "deprecatioKn", "deprecation" })
public class GoogleCalendarAuth {
        private static final String APPLICATION_NAME = "ProManager";
        private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        private static final String TOKENS_DIRECTORY_PATH = "tokens";

        public static Credential getCredentials() throws Exception {
                String chemin;
                String osName = System.getProperty("os.name").toLowerCase();

                if (osName.contains("mac")) {
                        chemin = "/Users/its.aliiiiiiii/Desktop/Project/ProjetJava/ProManager/ProManager/src/main/java/com/promanager/promanager/Metier/Service/credentials.json";
                } else if (osName.contains("win")) {
                        chemin = "C:\\Users\\pc\\Desktop\\ProManager\\ProManager\\ProManager\\src\\main\\java\\com\\promanager\\promanager\\Metier\\Service\\credentials.json";
                } else {
                        chemin = "src\\main\\java\\com\\promanager\\promanager\\credentials.json";
                }

                FileInputStream in = new FileInputStream(chemin);
                GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

                GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                                GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, clientSecrets,
                                Arrays.asList("https://www.googleapis.com/auth/calendar.readonly",
                                                "https://www.googleapis.com/auth/tasks.readonly"))
                                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
                                .setAccessType("offline").build();

                return new AuthorizationCodeInstalledApp(
                                flow,
                                new LocalServerReceiver.Builder().setPort(8080).build())
                                .authorize("user");
        }

        public static Calendar getCalendarService() throws Exception {
                Credential credential = getCredentials();
                return new Calendar.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                                .setApplicationName(APPLICATION_NAME)
                                .build();
        }

        public static Tasks getTasksService() throws Exception {
                Credential credential = getCredentials();
                return new Tasks.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                                .setApplicationName(APPLICATION_NAME)
                                .build();
        }

        // private static List<Task> getTasks(String taskListId) throws Exception {
        // Tasks service = getTasksService();
        // Tasks.TasksOperations.List request = service.tasks().list(taskListId);
        // com.google.api.services.tasks.model.Tasks tasks = request.execute();
        // return tasks.getItems() != null ? tasks.getItems() : Collections.emptyList();
        // }
}
