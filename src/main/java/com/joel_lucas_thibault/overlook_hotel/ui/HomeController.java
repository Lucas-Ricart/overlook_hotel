package com.joel_lucas_thibault.overlook_hotel.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {
    @FXML private Label welcomeLabel;

    public void setWelcomeMessage(String username) {
        welcomeLabel.setText("Bienvenue, " + username + " !");
    }
}
