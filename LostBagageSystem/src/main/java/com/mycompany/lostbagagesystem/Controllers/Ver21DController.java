package com.mycompany.lostbagagesystem.Controllers;

import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.lostbagagesystem.models.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * @author is
 */
public class Ver21DController implements Initializable {

    @FXML
    private TableView table;
    
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

    private void handleAdd(ActionEvent event) {
        userList.add(new User(userIdCounter++, "?", "?", false));
    }
    
    private void handleDelete(ActionEvent event) {
        User user = (User) table.getSelectionModel().getSelectedItem();

        userList.remove(user);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = FXCollections.observableArrayList();

        userList.add(new User(userIdCounter++, "Donovan", "Ooit", true));
        userList.add(new User(userIdCounter++, "Peter", "Morgen", true));
        userList.add(new User(userIdCounter++, "Claar", "Gister", true));

        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn column = (TableColumn) table.getColumns().get(i);
            column.setCellValueFactory(new PropertyValueFactory(column.getId()));
        }
        
        table.setItems(userList);

    }
    
}
