package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.lostbagagesystem.models.bagageTabel;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * @author is
 */
public class Gev21DController implements Initializable {

    @FXML
    private TableView table;
    private ObservableList<bagageTabel> bagagetabel;
//    private ObservableList<User> userList;

//    private int userIdCounter = 0;
//    @FXML
//    private TableColumn<?, ?> id;
//    @FXML
//    private TableColumn<?, ?> werknemer;
//    @FXML
//    private TableColumn<?, ?> locatie;
//    @FXML
//    private TableColumn<?, ?> actief;
    @FXML
    private AnchorPane gev21D;

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

            bagagetabel.add(new bagageTabel(registration_nr, date_found, time_found,
                    luggage_type, brand, arrived_with_flight, luggage_tag,
                    location_found, main_color, second_color, size, weight, passanger_name,
                    city, other_characteristics));
        }

        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn column = (TableColumn) table.getColumns().get(i);
            column.setCellValueFactory(new PropertyValueFactory(column.getId()));
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
                = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Gevonden bagage, 21 dagen");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Bagage");
        //populating the series with data
        
        series.getData().add(new XYChart.Data(1, 1));
        series.getData().add(new XYChart.Data(2, 2));
        series.getData().add(new XYChart.Data(3, 3));
        series.getData().add(new XYChart.Data(4, 4));
        series.getData().add(new XYChart.Data(5, 5));
        series.getData().add(new XYChart.Data(6, 6));
        series.getData().add(new XYChart.Data(7, 7));
        series.getData().add(new XYChart.Data(8, 8));
        series.getData().add(new XYChart.Data(9, 9));
        series.getData().add(new XYChart.Data(10, 10));
        series.getData().add(new XYChart.Data(11, 11));
        series.getData().add(new XYChart.Data(12, 12));
        series.getData().add(new XYChart.Data(13, 13));
        series.getData().add(new XYChart.Data(14, 14));
        series.getData().add(new XYChart.Data(15, 15));
        series.getData().add(new XYChart.Data(16, 16));
        series.getData().add(new XYChart.Data(17, 17));
        series.getData().add(new XYChart.Data(18, 18));
        series.getData().add(new XYChart.Data(19, 19));
        series.getData().add(new XYChart.Data(20, 20));
        series.getData().add(new XYChart.Data(21, 21));

        lineChart.getData().add(series);
        gev21D.getChildren().setAll();
        gev21D.getChildren().setAll(lineChart);

        lineChart.prefWidthProperty().bind(gev21D.widthProperty());
        lineChart.prefHeightProperty().bind(gev21D.heightProperty());
    }
}


