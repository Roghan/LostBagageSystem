/*Controller Class voor het Administratiescherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.Medewerker;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.DbNaam;
import com.mycompany.lostbagagesystem.models.PopupMeldingen;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * @author is Youri Pel
 */
public class AdminMainController implements Initializable {

    @FXML
    private TableView table;

    private ObservableList<DbNaam> dbNaam;

    private Button Loguit;

    @FXML
    private AnchorPane TableLeeg;

    @FXML
    private AnchorPane AdminPane;

    @FXML
    private TextField txtZoek;

    private String filter;

//    private int userChangeId;
//
//    public AdminMainController(int userChangeId) {
//        this.userChangeId = userChangeId;
//    }
//
//    public int getuserChangeId() {
//        return userChangeId;
//    }
//    @FXML
//    private Button Blokkeren;
//
//    @FXML
//    private Button Verwijderen;
    @FXML
    private void blokkeer(ActionEvent event) throws IOException {
        if (table.getSelectionModel().isEmpty() == false) {
            ConnectDB db = new ConnectDB("lbs_database");

            DbNaam user = (DbNaam) table.getSelectionModel().getSelectedItem();
            String query = "UPDATE gebruiker SET blok = '1' WHERE id = '" + user.getId() + "'";
            db.executeUpdateQuery(query);
            user.setBlok(1);
            table.refresh();
        }
    }

    @FXML
    private void handleEdit(ActionEvent event) throws IOException, SQLException {
        if (!table.getSelectionModel().isEmpty()) {
            DbNaam user = (DbNaam) table.getSelectionModel().getSelectedItem();
            int userChangeId = user.getId();
            EditMedewerkerController emc = new EditMedewerkerController();
            emc.medewerkerWijzigen(userChangeId);
            System.out.println("userChangeId = " + userChangeId);
            //laad de nieuwe table in de bestaande anchorpane        
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/EditMedewerker.fxml"));
            //maakt de oude table leeg
            AdminPane.getChildren().setAll();
            //laad de nieuwe table in
            AdminPane.getChildren().setAll(pane);
            //geeft de nieuwe table de juiste groote
            pane.prefWidthProperty().bind(AdminPane.widthProperty());
            pane.prefHeightProperty().bind(AdminPane.widthProperty());
        }
    }

    @FXML
    public void handleAdd(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/NewMedewerker.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        AdminPane.getChildren().setAll();
        //laad de nieuwe table in
        AdminPane.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(AdminPane.widthProperty());
        pane.prefHeightProperty().bind(AdminPane.heightProperty());

    }

    @FXML
    private void deBlokkeer(ActionEvent event) {

        if (table.getSelectionModel().isEmpty() == false) {
            ConnectDB db = new ConnectDB("lbs_database");

            DbNaam user = (DbNaam) table.getSelectionModel().getSelectedItem();
            String query = "UPDATE gebruiker SET blok = '0' WHERE id = '" + user.getId() + "'";
            db.executeUpdateQuery(query);
            user.setBlok(0);
            table.refresh();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            dbTableFill();
        } catch (SQLException ex) {
            Logger.getLogger(AdminMainController.class.getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    public void logUit(ActionEvent event) throws IOException {
        MainApp.loadFXMLFile(AdminPane, "/fxml/InlogScherm.fxml");
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
