package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.lostbagagesystem.models.User;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * @author is
 */
public class AdminMainController implements Initializable {

    @FXML
    private TableView table;

    private ObservableList<User> userList;

    private int userIdCounter = 0;

//    @FXML
//    private Button Blokkeren;
//
//    @FXML
//    private Button Verwijderen;
    @FXML
    private void zoekMedewerkerField(ActionEvent event) {

    }

    @FXML
    private void handleAdd(ActionEvent event) {
        userList.add(new User(userIdCounter++, "?", "?", false));
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        User user = (User) table.getSelectionModel().getSelectedItem();

        userList.remove(user);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = FXCollections.observableArrayList();

        userList.add(new User(userIdCounter++, "Lennard", "Ooit", true));
        userList.add(new User(userIdCounter++, "Peter", "Morgen", true));
        userList.add(new User(userIdCounter++, "Claar", "Gister", true));

        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn column = (TableColumn) table.getColumns().get(i);
            column.setCellValueFactory(new PropertyValueFactory(column.getId()));
        }

        table.setItems(userList);

    }
    
    public void table() throws SQLException{
                ConnectDB db = new ConnectDB("fystestdb");

        int id;
        String voornaam;
        String achternaam;
                //show results
        ResultSet resultSet;

            resultSet = db.executeResultSetQuery("SELECT `id`, `voornaam`, `achternaam` FROM `gebruiker`");


            while (resultSet.next()) {
                id = resultSet.getInt("id");
                voornaam = resultSet.getString("voornaam");
                achternaam = resultSet.getString("achternaam");
                
                
                System.out.printf("%d = %s %s%n", id, voornaam, achternaam);
            }
    }

}
