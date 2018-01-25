/*Controller Class voor het Gevonden3Dagen Scherm
*/

package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.Vergelijk;
import javafx.fxml.FXML;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * @author is Koen van der Tuin
 */
public class Verg3DController implements Initializable {

    @FXML
    private AnchorPane gev21D;
    public int aantalDagen = 3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        {
            try {
                Vergelijk.vergelijken(aantalDagen , gev21D);
                
            } catch (SQLException ex) {
                Logger.getLogger(Verg21DController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
