/*Controller Class voor de medewerker Table voor het ManagerScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.Controllers.ManMainController;
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.models.DbNaam;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

<<<<<<< HEAD

=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
>>>>>>> parent of 648cf8f7... Revert "Merge branch 'master' of https://github.com/Roghan/LostBagageSystem"
/**
 * FXML Controller class
 *
 * @author Youri Pel
 */
public class ManMedewerkerViewController implements Initializable {

    @FXML
    private TableView table;

    private ObservableList<DbNaam> dbNaam;
    @FXML
    private AnchorPane tablepane;
    @FXML
    private TextField txtZoek;

    private String filter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            dbTableFill();
        } catch (SQLException ex) {
            Logger.getLogger(ManMainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtZoek.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                try {
                    if (txtZoek.getText() != null) {
                        filter = txtZoek.getText();
                        dbTableFillWithFilter();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

    }

    public void dbTableFill() throws SQLException {

        ConnectDB db = new ConnectDB("lbs_database");

        int id;
        String acountnaam;
        String wachtwoord;
        int rol;
        int blok;

        ResultSet resultSet;

        dbNaam = FXCollections.observableArrayList();

        resultSet = db.executeResultSetQuery("SELECT `id`, `acountnaam`, "
                + "`wachtwoord`, `rol`, `blok` FROM `gebruiker`");

        while (resultSet.next()) {
            id = resultSet.getInt("id");
            acountnaam = resultSet.getString("acountnaam");
            wachtwoord = resultSet.getString("wachtwoord");
            rol = resultSet.getInt("rol");
            blok = resultSet.getInt("blok");
            dbNaam.add(new DbNaam(id, acountnaam, wachtwoord, rol, blok));
        }

        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn column = (TableColumn) table.getColumns().get(i);
            column.setCellValueFactory(new PropertyValueFactory(column.getId()));
        }

        table.setItems(dbNaam);

    }

    public void dbTableFillWithFilter() throws SQLException {

        ConnectDB db = new ConnectDB("lbs_database");

        int id;
        String acountnaam;
        String wachtwoord;
        int rol;
        int blok;

        ResultSet resultSet;

        dbNaam = FXCollections.observableArrayList();

        String query = "SELECT `id`, `acountnaam`,`wachtwoord`, `rol`, `blok` FROM `gebruiker` WHERE"
                + "`acountnaam` LIKE '%" + filter + "%' ";
        resultSet = db.executeResultSetQuery(query);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
            acountnaam = resultSet.getString("acountnaam");
            wachtwoord = resultSet.getString("wachtwoord");
            rol = resultSet.getInt("rol");
            blok = resultSet.getInt("blok");
            dbNaam.add(new DbNaam(id, acountnaam, wachtwoord,
                    rol, blok));
        }

        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn column = (TableColumn) table.getColumns().get(i);
            column.setCellValueFactory(new PropertyValueFactory(column.getId()));
        }

        table.setItems(dbNaam);

    }
}
