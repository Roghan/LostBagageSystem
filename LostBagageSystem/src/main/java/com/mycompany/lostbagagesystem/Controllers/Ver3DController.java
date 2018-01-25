/*Controller Class voor het verloren3Dagen Scherm
*/

package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.TableFillMan;
import com.mycompany.lostbagagesystem.classes.Language;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import com.mycompany.lostbagagesystem.models.bagageTabel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * @author is Koen van der Tuin
 */
public class Ver3DController implements Initializable {

    @FXML
    private TableView table;
    private ObservableList<bagageTabel> bagagetabel;
    
    
    
    @FXML
    private AnchorPane gev21D;
    private int aantalDagen = 3;
    private String gevVer = Language.getTranslationString("TLK136");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            TableFillMan.dbTableFill(aantalDagen, table, gev21D, gevVer, 0);
        } catch (SQLException ex) {
            Logger.getLogger(Gev21DController.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

//    @FXML
//    public void dbTableFill(int aantalDagen) throws SQLException {
//
//    }
    

}

