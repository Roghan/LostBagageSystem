/*Controller Class voor De Systeem beheerders login
 *Momenteel word deze niet gebruikt
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.Language;
import java.io.IOException;
import java.util.ResourceBundle;
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
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerScherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane    
    }

    public void exportPDF(ActionEvent event) {

    }

}
