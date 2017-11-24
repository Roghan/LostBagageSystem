package com.mycompany.lostbagagesystem;

import java.io.File;
import java.util.Locale;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.stream.events.StartElement;

public class MainApp extends Application {

    private static final FileChooser FILE_CHOOSER = new FileChooser();

    @Override
    public void start(Stage stage) throws Exception {

        final String SCHERMNAAM = "Administratorscherm";
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + SCHERMNAAM +".fxml"));
        

//        final String SCHERMNAAM = "ManagerScherm";
//
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + SCHERMNAAM + ".fxml"));
//

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

        File selceltedFile = FILE_CHOOSER.showSaveDialog(null);
        return selceltedFile;
    }

    public static File selectFileToOpen() {

        File selceltedFile = FILE_CHOOSER.showOpenDialog(null);

        return selceltedFile;
    }
}
