/*Controller Class voor De Systeem beheerders login
 *Momenteel word deze niet gebruikt
 */
package com.mycompany.lostbagagesystem.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Marcel van Wilgenburg
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

    public void exportPDF(ActionEvent event) {

    }

}
