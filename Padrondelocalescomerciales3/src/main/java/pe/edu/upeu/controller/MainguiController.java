package pe.edu.upeu.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.Map;

public class MainguiController {
    @FXML BorderPane bp;
    @FXML TabPane tabPane;
    @FXML MenuItem menuItem1, menuItem2, menuItem3;

    @FXML
    public void initialize() {
        menuItem1.setOnAction(this::handleMenu);
        menuItem2.setOnAction(this::handleMenu);
        menuItem3.setOnAction(this::handleMenu);
    }

    private void handleMenu(ActionEvent e) {
        String id = ((MenuItem)e.getSource()).getId();
        Map<String, String[]> config = Map.of(
                "menuItem1", new String[]{"/view/main_cliente.fxml", "Padrón Comercial"},
                "menuItem2", new String[]{"/view/main_cliente.fxml", "Ventas"},
                "menuItem3", new String[]{"CLOSE", "Salir"}
        );

        if (config.get(id)[0].equals("CLOSE")) {
            Platform.exit(); System.exit(0);
        } else {
            cargarTab(config.get(id)[0], config.get(id)[1]);
        }
    }

    private void cargarTab(String fxml, String titulo) {
        try {
            Parent root = new FXMLLoader(getClass().getResource(fxml)).load();
            Tab tab = new Tab(titulo, new ScrollPane(root));
            tabPane.getTabs().clear();
            tabPane.getTabs().add(tab);
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}