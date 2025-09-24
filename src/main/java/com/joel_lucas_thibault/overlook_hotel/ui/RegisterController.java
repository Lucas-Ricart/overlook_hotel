package com.joel_lucas_thibault.overlook_hotel.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterController {
    @FXML private TextField nomField;
    @FXML private TextField prenomField;
    @FXML private TextField mailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;
    @FXML private Hyperlink goToLogin;

    @FXML
    private void handleRegister(ActionEvent event) {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String mail = mailField.getText();
        String password = passwordField.getText();
        errorLabel.setText("");
        if (nom.isEmpty() || prenom.isEmpty() || mail.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Tous les champs sont obligatoires");
            return;
        }
        try (Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO client (nom, prenom, mail, motdepasse, point_fidelite, salt, role) VALUES (?, ?, ?, ?, 0, '', 'CLIENT')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, mail);
            stmt.setString(4, password); // À remplacer par hashage sécurisé
            stmt.executeUpdate();
            errorLabel.setText("Inscription réussie, veuillez vous connecter.");
        } catch (Exception e) {
            errorLabel.setText("Erreur d'inscription : " + e.getMessage());
        }
    }

    @FXML
    private void goToLogin(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/ui/ClientLoginView.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) nomField.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
        } catch (Exception e) {
            errorLabel.setText("Erreur d'accès à la connexion");
        }
    }
}
