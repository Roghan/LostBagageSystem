package com.mycompany.lostbagagesystem.Controllers;

/*Controller Class voor het zoeken naar gevonden en verloren bagage formulieren
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.models.bagageTabel;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class FormulierZoekenController implements Initializable {

    @FXML
    private RadioButton filterLost;

    @FXML
    private ToggleGroup State;

    @FXML
    private RadioButton filterFound;

    @FXML
    private TableView<?> searchTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//    private static ObservableList<bagageTabel> bagagetabel;
//
//    private static ConnectDB db = new ConnectDB("fystestdb");
//    private static ResultSet resultSet;

//    @FXML
//    public static void dbTableFill() throws SQLException {
//
//        String registration_nr;
//        String date_found;
//        String time_found;
//        String luggage_type;
//        String brand;
//        String arrived_with_flight;
//        String luggage_tag;
//        String location_found;
//        String main_color;
//        String second_color;
//        String size;
//        String weight;
//        String passanger_name;
//        String city;
//        String other_characteristics;
//
//        bagagetabel = FXCollections.observableArrayList();
//        //SQL query
//        resultSet = db.executeResultSetQuery("SELECT `registration_nr`, "
//                + "`date_found`,`time_found`, `luggage_type`, `brand`, "
//                + "`arrived_with_flight`, `luggage_tag`, `location_found`, "
//                + "`main_color`, `second_color`, `size`, `weight`, "
//                + "`passanger_name`, `city`, `other_characteristics` FROM `gev310sep`");
//        //Get all the results out of the database
//        while (resultSet.next()) {
//            registration_nr = resultSet.getString("registration_nr");
//            date_found = resultSet.getString("date_found");
//            time_found = resultSet.getString("time_found");
//            luggage_type = resultSet.getString("luggage_type");
//            brand = resultSet.getString("brand");
//            arrived_with_flight = resultSet.getString("arrived_with_flight");
//            luggage_tag = resultSet.getString("luggage_tag");
//            location_found = resultSet.getString("location_found");
//            main_color = resultSet.getString("main_color");
//            second_color = resultSet.getString("second_color");
//            size = resultSet.getString("size");
//            weight = resultSet.getString("weight");
//            passanger_name = resultSet.getString("passanger_name");
//            city = resultSet.getString("city");
//            other_characteristics = resultSet.getString("other_characteristics");
//
//            //Current date - aantal dagen
//            Calendar c = Calendar.getInstance();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            c.add(Calendar.DATE, -aantalDagen);
//            String date = sdf.format(c.getTime());
//            //database date
//            String datadb = date_found + " " + time_found;
//
//            //if currentdate -aantaldagen <= to database date than show
//            if (date.compareTo(datadb) <= 0) {
//
//                bagagetabel.add(new bagageTabel(registration_nr, date_found, time_found,
//                        luggage_type, brand, arrived_with_flight, luggage_tag,
//                        location_found, main_color, second_color, size, weight, passanger_name,
//                        city, other_characteristics));
//
//                for (int i = 0; i < table.getColumns().size(); i++) {
//                    TableColumn column = (TableColumn) table.getColumns().get(i);
//                    column.setCellValueFactory(new PropertyValueFactory(column.getId()));
//                }
//            }
//        }
//
//        table.setItems(bagagetabel);
//
  }
