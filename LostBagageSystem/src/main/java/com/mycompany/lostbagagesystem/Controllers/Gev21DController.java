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
    private AnchorPane gev21D;

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

        userList.add(new User(userIdCounter++, "Youri", "Ooit", true));
        userList.add(new User(userIdCounter++, "Peter", "Morgen", true));
        userList.add(new User(userIdCounter++, "Claar", "Gister", true));

        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn column = (TableColumn) table.getColumns().get(i);
            column.setCellValueFactory(new PropertyValueFactory(column.getId()));
        }

        table.setItems(userList);
        getChart();

    }

    @FXML
    public void getChart() {

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Aantal dagen");
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<Number, Number>(xAxis, yAxis);

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


