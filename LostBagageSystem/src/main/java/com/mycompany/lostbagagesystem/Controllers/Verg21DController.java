/*Controller Class voor het Gevonden21Dagen Scherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.TableFillMan;
import com.mycompany.lostbagagesystem.classes.Vergelijk;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.bagageTabel;
import javafx.fxml.FXML;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * @author is Koen van der Tuin
 */
public class Verg21DController implements Initializable {
    
    @FXML
    private AnchorPane gev21D;
    public int aantalDagen = 21;

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