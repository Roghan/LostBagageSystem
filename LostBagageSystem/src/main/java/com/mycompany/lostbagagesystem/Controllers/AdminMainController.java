/*Controller Class voor het Administratiescherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.DbNaam;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author is Youri Pel
 */
public class AdminMainController implements Initializable {

    public ObservableList<DbNaam> dbNaam;

    private Button Loguit;

    @FXML
    private AnchorPane TableLeeg;

    @FXML
    private AnchorPane AdminPane;
    @FXML
    private BorderPane PaneLeeg;

//    @FXML
//    private Button Blokkeren;
//
//    @FXML
//    private Button Verwijderen;
    @FXML
    public void blokkeer(ActionEvent event) throws IOException {

        AdminMedewerkerViewController c = new AdminMedewerkerViewController();
        
        c.blokkeerUsr();
        
    }
    
    @FXML
    private void deBlokkeer(ActionEvent event) {
//        ConnectDB db = new ConnectDB("fystestdb");
//
//        DbNaam user = (DbNaam) table.getSelectionModel().getSelectedItem();
//        String query = "UPDATE gebruiker SET blok = '0' WHERE id = '" + user.getId() + "'";
//        db.executeUpdateQuery(query);
//        user.setBlok(0);
//        table.refresh();
    }
    
    /**
     * Add new medewerker pane
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleAdd(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
<<<<<<< HEAD
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/NewMedewerker.fxml"));
        
=======
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/NewMedewerker.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
>>>>>>> master
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());        
    }


    public void loadTabel() throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/AdminMedewerkerView.fxml"));
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            loadTabel();
        } catch (IOException ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param event
     * @throws IOException
     * Loguit functie
     */
    @FXML
    public void logUit(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
<<<<<<< HEAD
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/InlogScherm.fxml"));
=======
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/InlogScherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
>>>>>>> master
        //maakt de oude table leeg
        AdminPane.getChildren().setAll();
        //laad de nieuwe table in
        AdminPane.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(AdminPane.widthProperty());
        pane.prefHeightProperty().bind(AdminPane.heightProperty());
    }

}
