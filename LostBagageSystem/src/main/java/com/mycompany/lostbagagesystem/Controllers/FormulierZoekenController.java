package com.mycompany.lostbagagesystem.Controllers;

/*Controller Class voor het zoeken naar gevonden en verloren bagage formulieren
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class FormulierZoekenController implements Initializable {

    @FXML
    private RadioButton filterLost;

    @FXML
    private ToggleGroup StateSelect;

    @FXML
    private RadioButton filterFound;

    @FXML
    private TableView<?> searchTable;
    @FXML
    private TableView<MedewerkerBagageTable> bagage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dbTableFill();
        } catch (SQLException ex) {
            Logger.getLogger(FormulierZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ConnectDB db = new ConnectDB("lbs_database");
    private ResultSet resultSet;

    @FXML
    public void dbTableFill() throws SQLException {
        ObservableList<MedewerkerBagageTable> bagagetabel = FXCollections.observableArrayList();

        String BagageID;
        String State;
        String Labelnumber;
        String Type;
        String Brand;
        String Color1;
        String Color2;
        String Characteristics;
        String Location;
        String Airport;
        String From;
        String To;
        String Initial;
        String Insertion;
        String Surname;
        String IsReturned;

        //SQL query
        resultSet = db.executeResultSetQuery("SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Initial`,`Insertion`,`Surname`,`IsReturned` FROM `bagage`");
        //Get all the results out of the database
        while (resultSet.next()) {
            BagageID = resultSet.getString("BagageID");
            System.out.println(BagageID);
            State = resultSet.getString("State");
            System.out.println(State);
            Labelnumber = resultSet.getString("Labelnumber");
            Type = resultSet.getString("Type");
            Brand = resultSet.getString("Brand");
            Color1 = resultSet.getString("Color1");
            Color2 = resultSet.getString("Color2");
            Characteristics = resultSet.getString("Characteristics");
            Location = resultSet.getString("Location");
            Airport = resultSet.getString("Airport");
            From = resultSet.getString("From");
            To = resultSet.getString("To");
            Initial = resultSet.getString("Initial");
            Insertion = resultSet.getString("Insertion");
            Surname = resultSet.getString("Surname");
            IsReturned = resultSet.getString("IsReturned");

            bagagetabel.add(new MedewerkerBagageTable(BagageID, State, Type,Labelnumber, Brand, Color1, Color2,
                    Characteristics, Location, Airport, From, To, Initial, Insertion, Surname, IsReturned));

            for (int i = 0; i < bagage.getColumns().size(); i++) {
                TableColumn column = (TableColumn) bagage.getColumns().get(i);
                column.setCellValueFactory(new PropertyValueFactory(column.getId()));
            }

        }

        bagage.setItems(bagagetabel);

    }

}
