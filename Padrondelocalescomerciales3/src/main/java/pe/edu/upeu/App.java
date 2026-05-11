package pe.edu.upeu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Carga el menú principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/maingui.fxml"));

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // Ajusta la escena al tamaño de tu monitor
        Scene scene = new Scene(loader.load(), bounds.getWidth(), bounds.getHeight() - 100);

        // Aplica los estilos de Bootstrap que pide tu profesor
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        stage.setTitle("Sistema de Gestión - Padrón Comercial");
        stage.setScene(scene);
        stage.show();
    }
}