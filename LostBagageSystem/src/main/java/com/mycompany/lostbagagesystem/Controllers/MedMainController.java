/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dono
 */
public class MedMainController implements Initializable {
    
    @FXML
    private Button schadeformbtn;
    
    @FXML
    private Button Loguit;
    
    @FXML
    private AnchorPane MedewerkerPane;

    @FXML
        public void logUit(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/InlogScherm.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        MedewerkerPane.getChildren().setAll();
        //laad de nieuwe table in
        MedewerkerPane.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(MedewerkerPane.widthProperty());
        pane.prefHeightProperty().bind(MedewerkerPane.heightProperty());
        }
        
    @FXML
    private void schadeFormulier(ActionEvent event) throws IOException {
    Stage stage; 
    Parent root;
    stage = new Stage();
    root = FXMLLoader.load(getClass().getResource("/fxml/Schadeformulier.fxml"));
    stage.setScene(new Scene(root));
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.initOwner(schadeformbtn.getScene().getWindow());
    stage.showAndWait();
    }
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
