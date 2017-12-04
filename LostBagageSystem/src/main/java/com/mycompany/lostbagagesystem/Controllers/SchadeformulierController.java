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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dono
 */
public class SchadeformulierController implements Initializable {

    @FXML
    private TextField txtVoorletters;
    @FXML
    private TextField txtTussenvoegsel;
    @FXML
    private CheckBox checkM;
    @FXML
    private CheckBox checkV;
    @FXML
    private TextField txtAchternaam;
    @FXML
    private TextField txtStraatnaam;
    @FXML
    private TextField txtHuisNummer;
    @FXML
    private TextField txtPostcode;
    @FXML
    private TextField txtWoonplaats;
    @FXML
    private TextField txtGeboorteDatum;
    @FXML
    private TextField txtLandnaam;
    @FXML
    private TextField txtBankrekening;
    @FXML
    private TextField txtTelefoon;
    @FXML
    private TextField txtMobielNummer;
    @FXML
    private TextField txtEmail;
    @FXML
    private AnchorPane TableLeeg2;
    
    @FXML
    public void annuleren(ActionEvent event) throws IOException {  
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Medewerkersscherm.fxml"));
        TableLeeg2.getChildren().setAll();
        TableLeeg2.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(TableLeeg2.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg2.heightProperty());
    
    }
    
    @FXML 
    public void nxtPagina(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/SchadeformulierPagina2.fxml"));
        TableLeeg2.getChildren().setAll();
        TableLeeg2.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(TableLeeg2.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg2.heightProperty());
    
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
