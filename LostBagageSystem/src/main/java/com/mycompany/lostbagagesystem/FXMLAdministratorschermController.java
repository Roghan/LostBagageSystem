package com.mycompany.lostbagagesystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.lostbagagesystem.User;

/**
 * @author is
 */
public class FXMLAdministratorschermController {

    @FXML
    private TableView table;
    
    private ObservableList<User> userList;
    
    private int userIdCounter = 0;

//    @FXML
//    private Button Blokkeren;
//
//    @FXML
//    private Button Verwijderen;

//    @FXML
//    private void zoekMedewerkerField(ActionEvent event) {
//
//    }

//    @FXML
//    private void handleAdd(ActionEvent event) {
//        userList.add(new User(userIdCounter++, "?", "?", false));
//    }
    
    @FXML
    private void handleDelete(ActionEvent event) {
        User user = (User) table.getSelectionModel().getSelectedItem();

        userList.remove(user);
    }

//    @Override
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
    
}
