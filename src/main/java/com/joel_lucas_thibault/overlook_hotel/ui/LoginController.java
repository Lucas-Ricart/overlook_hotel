package com.joel_lucas_thibault.overlook_hotel.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        errorLabel.setText("");
        try (Connection conn = Database.getConnection()) {
            // Vérifier d'abord dans la table client
            String sqlClient = "SELECT motdepasse, role FROM client WHERE mail = ?";
            PreparedStatement stmtClient = conn.prepareStatement(sqlClient);
            stmtClient.setString(1, username);
            ResultSet rsClient = stmtClient.executeQuery();
            if (rsClient.next()) {
                String hashed = rsClient.getString("motdepasse");
                String role = rsClient.getString("role");
                // TODO: Remplacer par vérification BCrypt si le mot de passe est hashé
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
                return;
            }
            // Sinon, vérifier dans la table employer
            String sqlEmp = "SELECT motdepasse, role FROM employer WHERE mail = ?";
            PreparedStatement stmtEmp = conn.prepareStatement(sqlEmp);
            stmtEmp.setString(1, username);
            ResultSet rsEmp = stmtEmp.executeQuery();
            if (rsEmp.next()) {
                String hashed = rsEmp.getString("motdepasse");
                String role = rsEmp.getString("role");
                // TODO: Remplacer par vérification BCrypt si le mot de passe est hashé
                if (password.equals(hashed)) {
                    // Ici, vous pouvez charger une vue différente pour les gestionnaires si besoin
                    javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/ui/HomeView.fxml"));
                    javafx.scene.Parent root = loader.load();
                    HomeController homeController = loader.getController();
                    homeController.setWelcomeMessage(username + " (" + role + ")");
                    javafx.stage.Stage stage = (javafx.stage.Stage) usernameField.getScene().getWindow();
                    stage.setScene(new javafx.scene.Scene(root));
                } else {
                    errorLabel.setText("Mot de passe incorrect");
                }
                return;
            }
            errorLabel.setText("Utilisateur inconnu");
        } catch (Exception e) {
            errorLabel.setText("Erreur de connexion : " + e.getMessage());
        }
    }
}
