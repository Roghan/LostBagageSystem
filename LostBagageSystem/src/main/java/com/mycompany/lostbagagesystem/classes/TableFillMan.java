/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.classes;

import com.mycompany.lostbagagesystem.models.bagageTabel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author User
 */
public class TableFillMan {

    private static ObservableList<bagageTabel> bagagetabel;

    public static ConnectDB db = new ConnectDB("fystestdb");
    public static ResultSet resultSet;

    @FXML
    public static void dbTableFill(int aantalDagen, TableView table, AnchorPane gev21D, String gevVer) throws SQLException {

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

        bagagetabel = FXCollections.observableArrayList();
        //SQL query
        resultSet = db.executeResultSetQuery("SELECT `registration_nr`, "
                + "`date_found`,`time_found`, `luggage_type`, `brand`, "
                + "`arrived_with_flight`, `luggage_tag`, `location_found`, "
                + "`main_color`, `second_color`, `size`, `weight`, "
                + "`passanger_name`, `city`, `other_characteristics` FROM `gev310sep`");
        //Get all the results out of the database
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
            c.add(Calendar.DATE, -aantalDagen);
            String date = sdf.format(c.getTime());
            //database date
            String datadb = date_found + " " + time_found;

            //if currentdate -aantaldagen <= to database date than show
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

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Aantal dagen");
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle(gevVer +" bagage, " + aantalDagen + " dagen");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Bagage");
        //populating the series with data
        
        int[] aantalKoffers = aantalVerloren(aantalDagen);
        for (int i = 0; i < aantalDagen; i++) {
            series.getData().add(new XYChart.Data(i, aantalKoffers[i]));
        }

        lineChart.getData().add(series);
        gev21D.getChildren().setAll();
        gev21D.getChildren().setAll(lineChart);

        lineChart.prefWidthProperty().bind(gev21D.widthProperty());
        lineChart.prefHeightProperty().bind(gev21D.heightProperty());

    }

    public static int[] aantalVerloren(int aantalDagen) throws SQLException {
        int aantalKoffers = 0;
        String date_found;
        int[] aantalVerloren = new int[aantalDagen];

        resultSet = db.executeResultSetQuery("SELECT `date_found` FROM `gev310sep`");
        while (resultSet.next()) {
            
            for (int i = 0; i < aantalDagen; i++) {

                date_found = resultSet.getString("date_found");

                String datadb = date_found;

                Calendar c1 = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                c1.add(Calendar.DATE, -i);
                String date1 = sdf1.format(c1.getTime());
                System.out.println(date1);
                if (date1.compareTo(datadb) == 0) {
                    aantalVerloren[i]++;
                    break;
                }

                System.out.println(aantalKoffers);
                aantalKoffers = 0;
            }
        }
        return aantalVerloren;
    }
}
