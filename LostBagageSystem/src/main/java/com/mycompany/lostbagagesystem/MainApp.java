/*Main Class van de app. Hier start het programma.
 */
package com.mycompany.lostbagagesystem;

import com.mycompany.lostbagagesystem.classes.language;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class MainApp extends Application {

    private static final FileChooser FILE_CHOOSER = new FileChooser();
    private Locale NL = new Locale("nl", "NL");

    @Override
    public void start(Stage stage) throws Exception {
        language.setCurrentLocale(NL);

        final String SCHERMNAAM = "InlogScherm";

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + SCHERMNAAM + ".fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale()));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Lost Bagage System");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    public static File selectFileToSave() {

        FILE_CHOOSER.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("pdf Files", "*.pdf"));

        File selectedFile = FILE_CHOOSER.showSaveDialog(null);
        return selectedFile;
    }

    public static File selectFileToOpen() {

        File selectedFile = FILE_CHOOSER.showOpenDialog(null);

        return selectedFile;
    }

    public static Object loadFXMLFile(Pane parent, String fxmlFileName) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxmlFileName), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale()));
            Pane pane = fxmlLoader.load();

            parent.getChildren().clear();
            parent.getChildren().add(pane);
            pane.prefWidthProperty().bind(parent.widthProperty());
            pane.prefHeightProperty().bind(parent.heightProperty());
            return fxmlLoader.getController();

        } catch (IOException ex) {
            System.out.println(ex.getClass().getName() + ": " + ex.getMessage());
            return null;
        }

    }

    public static Object loadFXMLFileInNewWindow(String fxmlFileName) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxmlFileName), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale()));
        Pane pane = fxmlLoader.load();

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Matching window");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        return fxmlLoader.getController();

    }

}
