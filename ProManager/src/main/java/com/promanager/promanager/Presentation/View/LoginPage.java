package com.promanager.promanager.Presentation.View;

import com.promanager.promanager.Presentation.Controller.LoginPageController;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginPage extends AnchorPane {
        @SuppressWarnings("unused")
        private LoginPageController controller;
        private TextField mailField;
        private Button loginButton;
        private Text errorOutputText;
        Text proManagerText;
        Text manageTasksText;

        public TextField getMailField() {
                return mailField;
        }

        public Button getLoginButton() {
                return loginButton;
        }

        public Text getErrorOutputText() {
                return errorOutputText;
        }

        public LoginPage() {
                this.loginButton = new Button();
                this.mailField = new TextField();
                this.errorOutputText = new Text();
                this.manageTasksText = new Text();
                this.proManagerText = new Text();
                Pane pane = new Pane();

                this.controller = new LoginPageController(this);

                pane.setLayoutX(352.0);
                pane.setLayoutY(225.0);
                pane.setPrefHeight(363.0);
                pane.setPrefWidth(646.0);
                pane.setStyle("-fx-background-color: #fff; -fx-background-radius: 30px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 10, 0, 0, 0);");
                AnchorPane.setBottomAnchor(pane, 212.0);
                AnchorPane.setLeftAnchor(pane, 327.0);
                AnchorPane.setRightAnchor(pane, 327.0);
                AnchorPane.setTopAnchor(pane, 225.0);

                this.loginButton.setId("login");
                this.loginButton.setLayoutX(399.0);
                this.loginButton.setLayoutY(237.0);
                this.loginButton.setMnemonicParsing(false);
                this.loginButton.setPrefHeight(40.0);
                this.loginButton.setPrefWidth(110.0);
                this.loginButton.setText("Se Connecter");
                this.loginButton.setTextFill(javafx.scene.paint.Color.WHITE);
                this.loginButton.setFont(new Font(14.0));
                this.loginButton.setStyle(
                                "-fx-background-color:#6a82ab; -fx-border-radius:12px; -fx-background-radius:12px; -fx-border-color:#546379; -fx-border-width:2px;");

                this.mailField.setId("mail");
                this.mailField.setLayoutX(118.0);
                this.mailField.setLayoutY(171.0);
                this.mailField.setPrefHeight(53.0);
                this.mailField.setPrefWidth(396.0);
                this.mailField.setPromptText("   Mail");
                this.mailField.setFont(new Font(24.0));
                this.mailField.setStyle(
                                "-fx-background-color:#f4f4f4; -fx-border-radius:20px; -fx-background-radius:20px; -fx-border-color:#546379; -fx-border-width:2px;");

                this.proManagerText.setFill(javafx.scene.paint.Color.web("#6a82ab"));
                this.proManagerText.setFontSmoothingType(javafx.scene.text.FontSmoothingType.LCD);
                this.proManagerText.setLayoutX(188.0);
                this.proManagerText.setLayoutY(81.0);
                this.proManagerText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                this.proManagerText.setStrokeWidth(0.0);
                this.proManagerText.setText("ProManager");
                this.proManagerText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
                this.proManagerText.setWrappingWidth(260);
                this.proManagerText.setFont(new Font("Al Nile Bold", 36.0));

                this.manageTasksText.setLayoutX(160.0);
                this.manageTasksText.setLayoutY(120.0);
                this.manageTasksText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                this.manageTasksText.setStrokeWidth(0.0);
                this.manageTasksText.setText("Gérez facilement vos tâches et projets");
                this.manageTasksText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
                this.manageTasksText.setWrappingWidth(313);
                this.manageTasksText.setFont(new Font(18.0));

                this.errorOutputText.setFill(javafx.scene.paint.Color.web("#d74949"));
                this.errorOutputText.setLayoutX(126.0);
                this.errorOutputText.setLayoutY(250.0);
                this.errorOutputText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                this.errorOutputText.setStrokeWidth(0.0);
                this.errorOutputText.setWrappingWidth(222);

                pane.getChildren().addAll(loginButton, mailField, proManagerText, manageTasksText, this.errorOutputText);
                getChildren().addAll(pane);
                setStyle("-fx-background-color:#6a82ab;");
        }

}
