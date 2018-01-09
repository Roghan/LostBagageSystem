/*Controller Class voor het Verloren21dagenScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.TableFillMan;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.lostbagagesystem.models.User;
import com.mycompany.lostbagagesystem.models.bagageTabel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * @author is Koen van der Tuin
 */
public class Ver21DController implements Initializable {

    @FXML
    private TableView table;
    private ObservableList<bagageTabel> bagagetabel;
    
    
    
    @FXML
    private AnchorPane gev21D;
    private int aantalDagen = 21;
    private String gevVer = "Verloren";
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            TableFillMan.dbTableFill(aantalDagen, table, gev21D, gevVer, false);
        } catch (SQLException ex) {
            Logger.getLogger(Gev21DController.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

}
