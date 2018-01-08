/*Controller Class voor het gevonden bagage Scherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.TableFillMan;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.lostbagagesystem.models.User;
import com.mycompany.lostbagagesystem.models.BagageTabel;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 * @author is Marcel van Wilgenburg
 */
public class Gev3DController implements Initializable {

    @FXML
    private TableView table;
    private ObservableList<BagageTabel> bagagetabel;
    
    
    
    @FXML
    private AnchorPane gev21D;
    private int aantalDagen = 3;
    private String gevVer = "Gevonden";
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            TableFillMan.dbTableFill(aantalDagen, table, gev21D, gevVer);
        } catch (SQLException ex) {
            Logger.getLogger(Gev21DController.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

//    @FXML
//    public void dbTableFill(int aantalDagen) throws SQLException {
//
//    }
    

}
