package com.mycompany.lostbagagesystem.Controllers;

/*Controller Class voor het zoeken naar gevonden en verloren bagage formulieren
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.Language;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class FormulierZoekenController implements Initializable {

    @FXML
    private ToggleGroup Filter;

    @FXML
    private TextField txtFilter;

    @FXML
    private TableView<MedewerkerBagageTable> bagage;

    @FXML
    private ToggleGroup txtBoxFilter;

    @FXML
    private MenuButton filterBox;

    private ConnectDB db = new ConnectDB("lbs_database");

    private final String noFilter = Language.getTranslationString("TLK138");
    private final String lost = Language.getTranslationString("TLK136");
    private final String found = Language.getTranslationString("TLK137");
    private String filterText;
    private String BagageID;
    private String State;
    private String Labelnumber;
    private String Type;
    private String Brand;
    private String Color1;
    private String Color2;
    private String Characteristics;
    private String Location;
    private String Airport;
    private String From;
    private String To;
    private String Initial;
    private String Insertion;
    private String Surname;
    private String IsReturned;
    private ResultSet resultSet = null;
    private String txtBoxFilterString;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            resultSetNoFilter();
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(FormulierZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtFilter.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                try {
                    filterSelector();
                } catch (SQLException ex) {
                    Logger.getLogger(FormulierZoekenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    @FXML
    public void dbTableFill(ActionEvent event) throws SQLException {
        filterSelector();
    }

    @FXML
    public void filterSelector() throws SQLException {

        if (txtFilter.getText().isEmpty()) {

            //GetFilterState
            RadioButton r = (RadioButton) Filter.getSelectedToggle();
            String filter = r.getText();

            if (filter.equals(noFilter)) {
                resultSetNoFilter();

            } else if (filter.equals(lost)) {
                resultSetLost();

            } else if (filter.equals(found)) {
                resultSetFound();

            }

            //SQL query based on filter state
            fillTable();

        } else {


            //GetFilterState
            RadioButton r = (RadioButton) Filter.getSelectedToggle();
            String filter = r.getText();
            filterText = txtFilter.getText();

            if (filter.equals(noFilter)) {
                resultSetNoFilterWithTextFilter();

            } else if (filter.equals(lost)) {
                resultSetLostWithTextFilter();

            } else if (filter.equals(found)) {
                resultSetFoundWithTextFilter();

            }

            //SQL query based on filter state
            fillTable();

        }
    }

    public void fillTable() throws SQLException {

        ObservableList<MedewerkerBagageTable> bagagetabel = FXCollections.observableArrayList();
        ObservableList<MedewerkerBagageTable> emptyList = FXCollections.observableArrayList();

        bagage.setItems(emptyList);

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

            bagagetabel.add(new MedewerkerBagageTable(BagageID, State, Labelnumber, Type, Brand, Color1, Color2,
                    Characteristics, Location, Airport, From, To, Initial, Insertion, Surname, IsReturned));

            for (int i = 0; i < bagage.getColumns().size() ; i++) {
                TableColumn column = (TableColumn) bagage.getColumns().get(i);
                column.setCellValueFactory(new PropertyValueFactory(column.getId()));
            }

        }

        bagage.setItems(bagagetabel);

    }

    public void resultSetNoFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Initial`,`Insertion`,`Surname`,`IsReturned` FROM `bagage`";
        resultSet = db.executeResultSetQuery(query);

    }

    public void resultSetLost() throws SQLException {
        resultSet = db.executeResultSetQuery("SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Initial`,`Insertion`,`Surname`,`IsReturned` FROM `bagage` WHERE State = 'Lost'");

    }

    public void resultSetFound() throws SQLException {
        resultSet = db.executeResultSetQuery("SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Initial`,`Insertion`,`Surname`,`IsReturned` FROM `bagage` WHERE State = 'Found'");

    }

    public void resultSetNoFilterWithTextFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Initial`,`Insertion`,`Surname`,`IsReturned` FROM `bagage`"
                + "WHERE `" + txtBoxFilterString + "` LIKE '%" + filterText + "%'";
        resultSet = db.executeResultSetQuery(query);

    }

    public void resultSetLostWithTextFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Initial`,`Insertion`,`Surname`,`IsReturned` FROM `bagage` WHERE State = 'Lost'"
                + "AND `" + txtBoxFilterString + "` LIKE '%" + filterText + "%'";
        resultSet = db.executeResultSetQuery(query);

    }

    public void resultSetFoundWithTextFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Initial`,`Insertion`,`Surname`,`IsReturned` FROM `bagage` WHERE State = 'Found'"
                + "AND `" + txtBoxFilterString + "` LIKE '%" + filterText + "%'";
        resultSet = db.executeResultSetQuery(query);

    }

    @FXML
    public void setTxtFilter(ActionEvent event) {
        RadioMenuItem tg = (RadioMenuItem) txtBoxFilter.getSelectedToggle();
        String menuTxt = tg.getText();
        filterBox.setText(menuTxt);
        if (Language.getTranslationString("TLK36").equals(menuTxt)) {
            txtBoxFilterString = "Labelnumber";
        }
        if (Language.getTranslationString("TLK130").equals(menuTxt)) {
            txtBoxFilterString = "From";
        }
        if (Language.getTranslationString("TLK131").equals(menuTxt)) {
            txtBoxFilterString = "To";
        }
        if (Language.getTranslationString("TLK10").equals(menuTxt)) {
            txtBoxFilterString = "Surname";
        }

    }

}
