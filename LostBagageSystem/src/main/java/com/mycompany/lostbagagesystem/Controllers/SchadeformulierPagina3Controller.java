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
public class SchadeformulierPagina3Controller implements Initializable {
    @FXML
    private AnchorPane TableLeeg5;
    
    @FXML
    public void annuleren3(ActionEvent event) throws IOException {  
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Medewerkersscherm.fxml"));
        TableLeeg5.getChildren().setAll();
        TableLeeg5.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(TableLeeg5.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg5.heightProperty());
    
    }
    
    @FXML
    public void lstPagina2(ActionEvent event) throws IOException {  
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/SchadeformulierPagina2.fxml"));
        TableLeeg5.getChildren().setAll();
        TableLeeg5.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(TableLeeg5.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg5.heightProperty());
    
    }
    
    @FXML
    public void insturen(ActionEvent event) throws IOException {  
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Medewerkersscherm.fxml"));
        TableLeeg5.getChildren().setAll();
        TableLeeg5.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(TableLeeg5.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg5.heightProperty());
    
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
