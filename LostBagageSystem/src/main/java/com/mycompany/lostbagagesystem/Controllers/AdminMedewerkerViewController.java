/*Controller Class voor Het Medewerkerscherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.models.DbNaam;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Youri pel
 */
public class AdminMedewerkerViewController implements Initializable {

    @FXML
    private TableView table;

    private ObservableList<DbNaam> dbNaam;
    @FXML
    private AnchorPane tablepane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            dbTableFill();
        } catch (SQLException ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void dbTableFill() throws SQLException {

        ConnectDB db = new ConnectDB("fystestdb");

        int id;
        String acountnaam;
        String wachtwoord;
        int rol;
        int blok;

        ResultSet resultSet;

        dbNaam = FXCollections.observableArrayList();

        resultSet = db.executeResultSetQuery("SELECT `id`, `acountnaam`, "
                + "`wachtwoord`, `rol`, `blok` FROM `gebruiker`");

        while (resultSet.next()) {
            id = resultSet.getInt("id");
            acountnaam = resultSet.getString("acountnaam");
            wachtwoord = resultSet.getString("wachtwoord");
            rol = resultSet.getInt("rol");
            blok = resultSet.getInt("blok");
            dbNaam.add(new DbNaam(id, acountnaam, wachtwoord, rol, blok));
        }

        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn column = (TableColumn) table.getColumns().get(i);
            column.setCellValueFactory(new PropertyValueFactory(column.getId()));
        }

        table.setItems(dbNaam);

    }
}
