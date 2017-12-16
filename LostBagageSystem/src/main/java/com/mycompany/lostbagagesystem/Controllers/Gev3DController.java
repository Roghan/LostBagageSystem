/*Controller Class voor het gevonden bagage Scherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.lostbagagesystem.models.User;
import com.mycompany.lostbagagesystem.models.bagageTabel;
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

    @FXML

    private ObservableList<User> userList;

    private int userIdCounter = 0;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> werknemer;
    @FXML
    private TableColumn<?, ?> locatie;
    @FXML
    private TableColumn<?, ?> actief;
    @FXML
    private AnchorPane gev3D;
    @FXML
    private ObservableList<bagageTabel> bagagetabel;

    private void handleAdd(ActionEvent event) {
        userList.add(new User(userIdCounter++, "?", "?", false));
    }

    private void handleDelete(ActionEvent event) {
        User user = (User) table.getSelectionModel().getSelectedItem();

        userList.remove(user);
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            dbTableFill();
        } catch (SQLException ex) {
            Logger.getLogger(Gev21DController.class.getName()).log(Level.SEVERE, null, ex);
        }

        getChart();

    }
    
    @FXML
    public void dbTableFill() throws SQLException {
        ConnectDB db = new ConnectDB("fystestdb");

        String registration_nr;
        String date_found;
        String time_found;
        String luggage_type;
        String brand;
        String arrived_with_flight;
        String luggage_tag;
        String location_found;
        String main_color;
        String second_color;
        String size;
        String weight;
        String passanger_name;
        String city;
        String other_characteristics;

        ResultSet resultSet;

        bagagetabel = FXCollections.observableArrayList();

        resultSet = db.executeResultSetQuery("SELECT `registration_nr`, "
                + "`date_found`,`time_found`, `luggage_type`, `brand`, "
                + "`arrived_with_flight`, `luggage_tag`, `location_found`, "
                + "`main_color`, `second_color`, `size`, `weight`, "
                + "`passanger_name`, `city`, `other_characteristics` FROM `gev310sep`");

        while (resultSet.next()) {
            registration_nr = resultSet.getString("registration_nr");
            date_found = resultSet.getString("date_found");
            time_found = resultSet.getString("time_found");
            luggage_type = resultSet.getString("luggage_type");
            brand = resultSet.getString("brand");
            arrived_with_flight = resultSet.getString("arrived_with_flight");
            luggage_tag = resultSet.getString("luggage_tag");
            location_found = resultSet.getString("location_found");
            main_color = resultSet.getString("main_color");
            second_color = resultSet.getString("second_color");
            size = resultSet.getString("size");
            weight = resultSet.getString("weight");
            passanger_name = resultSet.getString("passanger_name");
            city = resultSet.getString("city");
            other_characteristics = resultSet.getString("other_characteristics");

            //Current date - aantal dagen
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            c.add(Calendar.DATE, -3);
            String date = sdf.format(c.getTime());
            //database date
            String datadb = date_found + " " + time_found;

            if (date.compareTo(datadb) <= 0) {

                bagagetabel.add(new bagageTabel(registration_nr, date_found, time_found,
                        luggage_type, brand, arrived_with_flight, luggage_tag,
                        location_found, main_color, second_color, size, weight, passanger_name,
                        city, other_characteristics));

                for (int i = 0; i < table.getColumns().size(); i++) {
                    TableColumn column = (TableColumn) table.getColumns().get(i);
                    column.setCellValueFactory(new PropertyValueFactory(column.getId()));
                }
            }
        }

        table.setItems(bagagetabel);
    }

    @FXML
    public void getChart() {

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Aantal dagen");
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Gevonden bagage, 3 dagen");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Bagage");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));

        lineChart.getData().add(series);
        gev3D.getChildren().setAll();
        gev3D.getChildren().setAll(lineChart);

        lineChart.prefWidthProperty().bind(gev3D.widthProperty());
        lineChart.prefHeightProperty().bind(gev3D.heightProperty());
    }

}
