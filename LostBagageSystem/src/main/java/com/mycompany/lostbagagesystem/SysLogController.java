/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Marcel
 */
public class SysLogController {

    public void medewerkerKnop(ActionEvent event) {
        

    }

    public void AdministratorKnop(ActionEvent event) {

    }

    public void managerKnop(ActionEvent event) throws IOException {
        BorderPane pane =  FXMLLoader.load(getClass().getResource("/fxml/ManagerschermGevonden3Dagen.fxml"));
        
    }
    
    public void exportPDF(ActionEvent event){
        
        
    }

}
