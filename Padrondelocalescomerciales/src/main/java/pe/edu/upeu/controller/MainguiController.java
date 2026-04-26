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
    public void initialize(){
        MenuItemListerner miL = new MenuItemListerner();
        menuItem1.setOnAction(miL::handle);
        menuItem2.setOnAction(miL::handle);
        menuItem3.setOnAction(miL::handle);
    }

    class MenuItemListerner {
        Map<String, String[]> menuConfig = Map.of(
                "menuItem1", new String[]{"/view/main_cliente.fxml", "Adm. Locales", "T"},
                "menuItem2", new String[]{"/view/main_cliente.fxml", "Reportes", "T"},
                "menuItem3", new String[]{"/view/login.fxml", "Salir", "C"}
        );

        public void handle(ActionEvent e){
            String id = ((MenuItem)e.getSource()).getId();
            if(menuConfig.containsKey(id)){
                String[] items = menuConfig.get(id);
                if(items[2].equals("C")){
                    Platform.exit(); System.exit(0);
                } else {
                    abrirTabPaneFXML(items[0], items[1]);
                }
            }
        }

        private void abrirTabPaneFXML(String fxmlPath, String title){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
                Parent root = loader.load();
                ScrollPane sp = new ScrollPane(root);
                sp.setFitToWidth(true); sp.setFitToHeight(true);
                Tab tab = new Tab(title, sp);
                tabPane.getTabs().clear();
                tabPane.getTabs().add(tab);
            } catch (IOException ex){ throw new RuntimeException(ex); }
        }
    }
}