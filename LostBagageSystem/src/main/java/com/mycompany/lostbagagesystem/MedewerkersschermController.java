/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem;

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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dono
 */
public class MedewerkersschermController implements Initializable {
    
    @FXML
    private Button schadeformbtn;
    
    @FXML
    private void handleButtonAction(ActionEvent event) 
                          throws IOException {
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
