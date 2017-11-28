package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.models.DbNaam;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.lostbagagesystem.models.User;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

//    private ObservableList<User> userList;

    private ObservableList<DbNaam> dbNaam;

//    private int userIdCounter = 0;

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
//        dbNaam.add(new DbNaam(userIdCounter++, "Acountnaam", "Voornaam", "Achternaam"));
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        DbNaam user = (DbNaam) table.getSelectionModel().getSelectedItem();

        dbNaam.remove(user);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            dbTableFill();
        } catch (SQLException ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void dbTableFill() throws SQLException{
        
        ConnectDB db = new ConnectDB("fystestdb");

        int id;
        String acountnaam;
        String wachtwoord;
        String voornaam;
        String achternaam;
        String geboortedatum;
        String postcode;
        String huisnummer;    
        String telefoonnummer;
        int manVrouw;
        int rol;    
        int blok;
        
        ResultSet resultSet;

        dbNaam = FXCollections.observableArrayList();

        resultSet = db.executeResultSetQuery("SELECT `id`, `acountnaam`, "
                + "`wachtwoord`, `voornaam`, `achternaam`, `geboortedatum`, "
                + "`postcode`, `huisnummer`, `telefoonnummer`, `man/vrouw`, "
                + "`rol`, `blok` FROM `gebruiker`");

        while (resultSet.next()) {
            id = resultSet.getInt("id");
            acountnaam = resultSet.getString("acountnaam");
            wachtwoord = resultSet.getString("wachtwoord");
            voornaam = resultSet.getString("voornaam");
            achternaam = resultSet.getString("achternaam");
            geboortedatum = resultSet.getString("geboortedatum");
            postcode = resultSet.getString("postcode");
            huisnummer = resultSet.getString("huisnummer");
            telefoonnummer = resultSet.getString("telefoonnummer");
            manVrouw = resultSet.getInt("man/vrouw");
            rol = resultSet.getInt("rol");
            blok = resultSet.getInt("blok");
            dbNaam.add(new DbNaam(id, acountnaam, wachtwoord, 
            voornaam, achternaam, geboortedatum, 
            postcode, huisnummer, telefoonnummer, 
            manVrouw, rol, blok));
        }

        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn column = (TableColumn) table.getColumns().get(i);
            column.setCellValueFactory(new PropertyValueFactory(column.getId()));
        }

        table.setItems(dbNaam);        
        
    }
    
}
