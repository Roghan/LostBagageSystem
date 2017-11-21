package com.mycompany.lostbagagesystem;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.Window;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final String SCHERMNAAM = "ManagerScherm";
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + SCHERMNAAM +".fxml"));
        
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
    

    
    
    
    
    
    
    

}
