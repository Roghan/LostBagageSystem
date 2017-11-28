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
public class Verg3DController implements Initializable {

    @FXML
    private AnchorPane verg3D;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    getChart();    

    }
    @FXML
    public void getChart () {
       
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Aantal dagen");
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Verloren bagage, 21 dagen");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Bagage verloren");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Bagage gevonden");
        //populating the series with data
        series2.getData().add(new XYChart.Data(1, 1));
        series2.getData().add(new XYChart.Data(2, 2));
        series2.getData().add(new XYChart.Data(3, 3));
                
        lineChart.getData().addAll(series, series2);
        verg3D.getChildren().setAll();
        verg3D.getChildren().setAll(lineChart);
        
        lineChart.prefWidthProperty().bind(verg3D.widthProperty());
        lineChart.prefHeightProperty().bind(verg3D.heightProperty());
    }
}
