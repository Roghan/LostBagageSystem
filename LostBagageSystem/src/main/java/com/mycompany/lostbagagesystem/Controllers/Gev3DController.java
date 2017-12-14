/*Controller Class voor het gevonden bagage Scherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.TableFillMan;
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

        getChart();

        try {
            TableFillMan.dbTableFill(-3, table);
        } catch (SQLException ex) {
            Logger.getLogger(Gev3DController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

//    @FXML
//    public void dbTableFill(int aantalDagen) throws SQLException {
//
//    }
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
