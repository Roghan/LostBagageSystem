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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author User
 */
public class TableFillMan {
    
    private static ObservableList<bagageTabel> bagagetabel; 
    
    
     @FXML
    public static void dbTableFill(int aantalDagen, TableView table) throws SQLException {
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
            c.add(Calendar.DATE, aantalDagen);
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
}
