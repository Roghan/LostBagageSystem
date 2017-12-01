/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Marcel
 */
public class SysLogController {
    
    @FXML
    public void medewerkerKnop(ActionEvent event) {
        

    }
    @FXML
    public void administratorKnop(ActionEvent event) {

    }
    
    @FXML
    public void managerKnop(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerScherm.fxml")); //laad de nieuwe table in de bestaande anchorpane    
    }
    
    public void exportPDF(ActionEvent event){
        
        
    }

}
