package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dono
 */
public class SchadeformulierPagina2Controller implements Initializable {
    @FXML
    private AnchorPane TableLeeg4;
    @FXML 
    public void nxtPagina(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/SchadeformulierPagina3.fxml"));
        TableLeeg4.getChildren().setAll();
        TableLeeg4.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(TableLeeg4.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg4.heightProperty());
    
    }
    
    @FXML
    public void lstPagina(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Schadeformulier.fxml"));
        TableLeeg4.getChildren().setAll();
        TableLeeg4.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(TableLeeg4.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg4.heightProperty());
    
    }
    
    @FXML
    public void annuleren2(ActionEvent event) throws IOException {  
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Medewerkersscherm.fxml"));
        TableLeeg4.getChildren().setAll();
        TableLeeg4.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(TableLeeg4.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg4.heightProperty());
    
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
