// import com.google.api.client.auth.oauth2.Credential;
// import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
// import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
// import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
// import com.google.api.client.http.HttpTransport;
// import com.google.api.client.json.JsonFactory;
// import com.google.api.client.json.jackson2.JacksonFactory;
// import com.google.api.services.calendar.Calendar;
// import com.google.api.services.oauth2.Oauth2;
// import com.google.api.services.people.v1.PeopleService;
// import com.google.api.services.people.v1.model.Person;
// import com.google.api.services.oauth2.model.Userinfo;
// import com.google.api.services.calendar.model.Event;
// import com.google.api.services.calendar.model.Events;

// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.util.Collections;

// public class GoogleAPIService {

//     private static final String APPLICATION_NAME = "Your_Application_Name";
//     private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//     private static final String TOKENS_DIRECTORY_PATH = "tokens";

//     private static final String[] SCOPES = {CalendarScopes.CALENDAR_READONLY};
//     private static final HttpTransport HTTP_TRANSPORT;

//     static {
//         try {
//             HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//         } catch (Exception e) {
//             throw new RuntimeException("Error initializing HTTP Transport", e);
//         }
//     }

//     public static void initiateGoogleSignIn() {
//         try {
//             // Load client secrets.
//             InputStream in = GoogleAPIService.class.getResourceAsStream("/credentials.json");
//             GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

//             // Build flow and trigger user authorization request.
//             GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                     HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, Collections.singletonList(SCOPES[0]))
//                     .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
//                     .setAccessType("offline")
//                     .build();
//             Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
//                     .authorize("user");

//             // Store the credential securely for future use.
//             // For now, you can print the access token.
//             System.out.println("Access token: " + credential.getAccessToken());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public static void fetchUserInfo() {
//         try {
//             // Build the OAuth2 service to make API requests.
//             Oauth2 oauth2 = new Oauth2.Builder(HTTP_TRANSPORT, JSON_FACTORY, null)
//                     .setApplicationName(APPLICATION_NAME)
//                     .build();

//             // Retrieve user information using the access token.
//             Userinfo userinfo = oauth2.userinfo().get().setAccessToken(credential.getAccessToken()).execute();

//             // Print user information.
//             System.out.println("User email: " + userinfo.getEmail());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public static boolean checkEmailExists(String email) {
//         try {
//             // Build the People API service to make API requests.
//             PeopleService peopleService = new PeopleService.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
//                     .setApplicationName(APPLICATION_NAME)
//                     .build();

//             // Get the person information for the specified email.
//             Person person = peopleService.people().get("people/" + email).execute();

//             // If person is not null, the email exists.
//             return person != null;
//         } catch (Exception e) {
//             e.printStackTrace();
//             return false;
//         }
//     }

//     public static void importCalendarEvents() {
//         try {
//             // Build the Calendar service to make API requests.
//             Calendar calendarService = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
//                     .setApplicationName(APPLICATION_NAME)
//                     .build();

//             // Get events from the user's primary calendar.
//             Events events = calendarService.events().list("primary").execute();

//             // Iterate through the events and do something with them.
//             for (Event event : events.getItems()) {
//                 // Process each event.
//                 System.out.println("Event summary: " + event.getSummary());
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
