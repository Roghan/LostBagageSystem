package com.mycompany.lostbagagesystem.Controllers;

/*Controller Class voor het zoeken naar gevonden en verloren bagage formulieren
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private String selectedListviewItem;
    private String Passnameandcity;
    private ObservableList<MedewerkerBagageTable> bagageTables = FXCollections.observableArrayList();

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
                    filterSelector();

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
            txtBoxFilterString = "Surname";
        }

    }

    @FXML
    public void findMatch(ActionEvent event) throws IOException {
        MedewerkerBagageTable medewerkerBagageTable = bagage.getSelectionModel().getSelectedItem();
        labelNumberForMatch = medewerkerBagageTable.getLabelnumber();
        setMatchWindow();

    }

    @FXML
    public void setMatchWindow() throws IOException {

        Stage stage = new Stage();
        final String SCHERMNAAM = "MatchListView";

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + SCHERMNAAM + ".fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale()));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Matching window");
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();

    }

    public void getFoundMatch() throws SQLException {
        String query = "SELECT * FROM `bagage` WHERE State = 'Lost'"
                + "AND `" + txtBoxFilterString + "` LIKE '%" + filterText + "%' AND  IsReturned NOT LIKE '1'";
        resultSet = db.executeResultSetQuery(query);
    }

    public static String getLabel() {
        return labelNumberForMatch;

    }

}
