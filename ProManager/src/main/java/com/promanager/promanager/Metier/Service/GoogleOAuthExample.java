// package com.promanager.promanager.Metier.Service;

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.layout.StackPane;
// import javafx.scene.web.WebView;
// import javafx.stage.Stage;

// public class GoogleOAuthExample extends Application {
//     private static final String CLIENT_ID = "your_client_id";
//     private static final String REDIRECT_URI = "your_redirect_uri";
//     private static final String AUTH_URL = "https://accounts.google.com/o/oauth2/auth?"
//             + "client_id=" + CLIENT_ID
//             + "&response_type=code"
//             + "&scope=https://www.googleapis.com/auth/calendar"
//             + "&redirect_uri=" + REDIRECT_URI;

//     @Override
//     public void start(Stage primaryStage) {
//         WebView webView = new WebView();
//         webView.getEngine().load(AUTH_URL);

//         webView.getEngine().locationProperty().addListener((obs, oldLocation, newLocation) -> {
//             if (newLocation.contains(REDIRECT_URI)) {
//                 // Extract authorization code from newLocation
//                 String authorizationCode = extractAuthorizationCode(newLocation);
//                 // Continue with the OAuth flow to get an access token
//                 System.out.println("Authorization Code: " + authorizationCode);
//                 // Complete the OAuth flow and close the WebView
//                 primaryStage.close();
//             }
//         });

//         StackPane root = new StackPane();
//         root.getChildren().add(webView);
//         primaryStage.setScene(new Scene(root, 800, 600));
//         primaryStage.show();
//     }

//     @SuppressWarnings("unused")
//     private String extractAuthorizationCode(String url) {
//         // Extract the authorization code from the redirect URI
//         String codePrefix = "code=";
//         int start = url.indexOf(codePrefix) + codePrefix.length();
//         int end = url.indexOf('&', start);
//         return (end > start) ? url.substring(start, end) : url.substring(start);
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
