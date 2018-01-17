/*Controller Class voor het gevonden 21 scherm
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
 * @author is Koen van der tuin
 */
public class Gev21DController implements Initializable {

    @FXML
    private TableView table;
    private ObservableList<bagageTabel> bagagetabel;

    @FXML
    private AnchorPane gev21D;
    private int aantalDagen = 21;
    private String gevVer = Language.getTranslationString("TLK91");

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            TableFillMan.dbTableFill(aantalDagen, table, gev21D, gevVer, 1);
        } catch (SQLException ex) {
            Logger.getLogger(Gev21DController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @throws SQLException Hiermee wordt de tabel gevuld met alle verloren
     * baggage die jonger is dan 21 dagen
     */
}
