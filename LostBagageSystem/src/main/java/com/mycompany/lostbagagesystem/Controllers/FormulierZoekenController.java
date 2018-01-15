package com.mycompany.lostbagagesystem.Controllers;

/*Controller Class voor het zoeken naar gevonden en verloren bagage formulieren
 */
import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import com.mycompany.lostbagagesystem.models.PopupMeldingen;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class FormulierZoekenController implements Initializable {

    @FXML
    protected ToggleGroup Filter;

    @FXML
    protected TextField txtFilter;

    @FXML
    protected TableView<MedewerkerBagageTable> bagage;

    @FXML
    protected ToggleGroup txtBoxFilter;

    @FXML
    protected MenuButton filterBox;

    @FXML
    protected AnchorPane listViewLoader;

    private ConnectDB db = new ConnectDB("lbs_database");

    private final String noFilter = language.getTranslationString("TLK138");
    private final String lost = language.getTranslationString("TLK136");
    private final String found = language.getTranslationString("TLK137");
    protected String filterText;
    protected String BagageID;
    protected String State;
    protected String Labelnumber;
    protected String Type;
    protected String Brand;
    protected String Color1;
    protected String Color2;
    protected String Characteristics;
    protected String Location;
    protected String Airport;
    protected String From;
    protected String To;
    protected String IsReturned;
    protected ResultSet resultSet = null;
    protected String txtBoxFilterString;
    protected String selectedListviewItem;
    protected String Passnameandcity;
    protected ObservableList<MedewerkerBagageTable> bagageTables = FXCollections.observableArrayList();
    private static MedewerkerBagageTable selectedBagage;

    private static String labelNumberForMatch;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            try {

                filterSelector();
            } catch (SQLException ex) {

            }
            resultSetNoFilter();
        } catch (SQLException ex) {

        }

        txtFilter.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                try {

                    if (filterBox.getText().equals(language.getTranslationString("TLK206"))) {
                        PopupMeldingen.kiesEerstEenFilter();
                        filterBox.setStyle("-fx-border-color : #ff0000;");
                    } else {
                        filterSelector();
                        filterBox.setStyle("");
                    }
                } catch (SQLException ex) {

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

    @FXML
    public void fillTable() throws SQLException {
        bagageTables.removeAll(bagageTables);

        int bagageID = 0;
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
            Passnameandcity = resultSet.getString("Passnameandcity");
            IsReturned = resultSet.getString("IsReturned");

            bagageTables.add(new MedewerkerBagageTable(BagageID, State, Labelnumber, Type, Brand, Color1, Color2, Characteristics, Location, Airport, From, To, Passnameandcity, IsReturned));

            for (int i = 0; i < bagage.getColumns().size(); i++) {
                TableColumn column = (TableColumn) bagage.getColumns().get(i);
                column.setCellValueFactory(new PropertyValueFactory(column.getId()));
            }

        }
        bagage.setItems(bagageTables);
    }

    public void resultSetNoFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Passnameandcity`,`IsReturned` FROM `bagage` WHERE  IsReturned NOT LIKE '1'";
        resultSet = db.executeResultSetQuery(query);

    }

    public void resultSetLost() throws SQLException {
        resultSet = db.executeResultSetQuery("SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Passnameandcity`,`IsReturned` FROM `bagage` WHERE State = 'Lost' AND  IsReturned NOT LIKE '1'");

    }

    public void resultSetFound() throws SQLException {
        resultSet = db.executeResultSetQuery("SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Passnameandcity`,`IsReturned` FROM `bagage` WHERE State = 'Found'AND  IsReturned NOT LIKE '1'");

    }

    public void resultSetNoFilterWithTextFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Passnameandcity`,`IsReturned` FROM `bagage`"
                + "WHERE `" + txtBoxFilterString + "` LIKE '%" + filterText + "%'AND  IsReturned NOT LIKE '1'";
        resultSet = db.executeResultSetQuery(query);

    }

    public void resultSetLostWithTextFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Passnameandcity`,`IsReturned` FROM `bagage` WHERE State = 'Lost'"
                + "AND `" + txtBoxFilterString + "` LIKE '%" + filterText + "%' AND  IsReturned NOT LIKE '1'";
        resultSet = db.executeResultSetQuery(query);

    }

    public void resultSetFoundWithTextFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Passnameandcity`,`IsReturned` FROM `bagage` WHERE State = 'Found'"
                + "AND `" + txtBoxFilterString + "` LIKE '%" + filterText + "%' AND  IsReturned NOT LIKE '1' ";
        resultSet = db.executeResultSetQuery(query);

    }

    @FXML
    public void setTxtFilter(ActionEvent event) {
        RadioMenuItem tg = (RadioMenuItem) txtBoxFilter.getSelectedToggle();
        String menuTxt = tg.getText();
        filterBox.setText(menuTxt);
        if (language.getTranslationString("TLK36").equals(menuTxt)) {
            txtBoxFilterString = "Labelnumber";
        }
        if (language.getTranslationString("TLK130").equals(menuTxt)) {
            txtBoxFilterString = "From";
        }
        if (language.getTranslationString("TLK131").equals(menuTxt)) {
            txtBoxFilterString = "To";
        }
        if (language.getTranslationString("TLK10").equals(menuTxt)) {
            txtBoxFilterString = "Passnameandcity";
        }

    }

    @FXML
    public void findMatch(ActionEvent event) throws IOException {

        if (bagage.getSelectionModel().getSelectedItem() != null) {
            selectedBagage = bagage.getSelectionModel().getSelectedItem();
            FormulierZoekenController form = (FormulierZoekenController) MainApp.loadFXMLFileInNewWindow("/fxml/MatchListView.fxml");

        } else {

            PopupMeldingen.maakEerstEenSelectie();

        }

    }

    public static MedewerkerBagageTable getSelectedBagage() {
        return selectedBagage;

    }

    @FXML
    public void setMatchWindow() throws IOException {

    }

}
