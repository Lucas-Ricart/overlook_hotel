package com.joel_lucas_thibault.overlook_hotel.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientLoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;
    @FXML private Hyperlink goToRegister;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        errorLabel.setText("");
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT motdepasse, role FROM client WHERE mail = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String hashed = rs.getString("motdepasse");
                String role = rs.getString("role");
                if (password.equals(hashed)) {
                    javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/ui/HomeView.fxml"));
                    javafx.scene.Parent root = loader.load();
                    HomeController homeController = loader.getController();
                    homeController.setWelcomeMessage(username + " (" + role + ")");
                    javafx.stage.Stage stage = (javafx.stage.Stage) usernameField.getScene().getWindow();
                    stage.setScene(new javafx.scene.Scene(root));
                } else {
                    errorLabel.setText("Mot de passe incorrect");
                }
            } else {
                errorLabel.setText("Utilisateur inconnu");
            }
        } catch (Exception e) {
            errorLabel.setText("Erreur de connexion : " + e.getMessage());
        }
    }

    @FXML
    private void goToRegister(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/ui/RegisterView.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) usernameField.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
        } catch (Exception e) {
            errorLabel.setText("Erreur d'accès à l'inscription");
        }
    }
}
