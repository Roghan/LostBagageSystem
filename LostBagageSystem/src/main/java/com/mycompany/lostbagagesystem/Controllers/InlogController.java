/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.PDFExport;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class InlogController implements Initializable {

    @FXML
    PasswordField passwordField;

    @FXML
    TextField username;

    private final String userName = "Admin"; //Hardcode for admins Needs to Change!!

    private final String passWord = "Admin";//Hardcode for admins Needs to Change!!

    @FXML
    AnchorPane ROOT;
    
    @FXML
    private Label statusMessage;

    public void login(ActionEvent event) throws IOException {

        if (userName.equals(username.getText())) {
            BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/SysteemBeheerderInlogScherm.fxml"));
            //maakt de oude table leeg
            ROOT.getChildren().setAll();
            //laad de nieuwe table in
            ROOT.getChildren().setAll(pane);
            //geeft de nieuwe table de juiste groote
            pane.prefWidthProperty().bind(ROOT.widthProperty());
            pane.prefHeightProperty().bind(ROOT.heightProperty());

        }

    }
    
        @FXML
    public void exportPDF(ActionEvent event) throws IOException {
        //Test output for console
        System.out.println("Button Press Print PDF");
        //Call the PDFExport class
        PDFExport doc = new PDFExport();
        //Add a new page to the pdf file
        doc.addPage();
        //Prompts the FileChooser
        doc.savePDF();

        statusMessage.setText(doc.getSavedLabelText());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
