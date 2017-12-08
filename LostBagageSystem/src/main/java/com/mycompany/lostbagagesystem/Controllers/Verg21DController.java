/*Controller Class voor het Gevonden21Dagen Scherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * @author is Koen van der Tuin
 */
public class Verg21DController implements Initializable {

    @FXML
    private AnchorPane verg21D;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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

        lineChart.setTitle("Verloren bagage, 21 dagen");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Bagage verloren");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        series.getData().add(new XYChart.Data(13, 15));
        series.getData().add(new XYChart.Data(14, 24));
        series.getData().add(new XYChart.Data(15, 34));
        series.getData().add(new XYChart.Data(16, 36));
        series.getData().add(new XYChart.Data(17, 22));
        series.getData().add(new XYChart.Data(18, 45));
        series.getData().add(new XYChart.Data(19, 43));
        series.getData().add(new XYChart.Data(20, 17));
        series.getData().add(new XYChart.Data(21, 29));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Bagage gevonden");
        //populating the series with data
        series2.getData().add(new XYChart.Data(1, 1));
        series2.getData().add(new XYChart.Data(2, 2));
        series2.getData().add(new XYChart.Data(3, 3));
        series2.getData().add(new XYChart.Data(4, 4));
        series2.getData().add(new XYChart.Data(5, 5));
        series2.getData().add(new XYChart.Data(6, 6));
        series2.getData().add(new XYChart.Data(7, 7));
        series2.getData().add(new XYChart.Data(8, 8));
        series2.getData().add(new XYChart.Data(9, 9));
        series2.getData().add(new XYChart.Data(10, 10));
        series2.getData().add(new XYChart.Data(11, 11));
        series2.getData().add(new XYChart.Data(12, 12));
        series2.getData().add(new XYChart.Data(13, 13));
        series2.getData().add(new XYChart.Data(14, 14));
        series2.getData().add(new XYChart.Data(15, 15));
        series2.getData().add(new XYChart.Data(16, 16));
        series2.getData().add(new XYChart.Data(17, 17));
        series2.getData().add(new XYChart.Data(18, 18));
        series2.getData().add(new XYChart.Data(19, 19));
        series2.getData().add(new XYChart.Data(20, 20));
        series2.getData().add(new XYChart.Data(21, 21));

        lineChart.getData().addAll(series, series2);
        verg21D.getChildren().setAll();
        verg21D.getChildren().setAll(lineChart);

        lineChart.prefWidthProperty().bind(verg21D.widthProperty());
        lineChart.prefHeightProperty().bind(verg21D.heightProperty());
    }
}
