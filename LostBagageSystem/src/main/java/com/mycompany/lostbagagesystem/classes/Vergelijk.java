package com.mycompany.lostbagagesystem.classes;

import static com.mycompany.lostbagagesystem.classes.TableFillMan.db;
import static com.mycompany.lostbagagesystem.classes.TableFillMan.resultSet;
import static com.mycompany.lostbagagesystem.classes.Vergelijk.aantalVerloren;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author User
 */
public class Vergelijk {
        
    static String  bagGev = Language.getTranslationString("TLK313");
    static String bagVer = Language.getTranslationString("TLK314");
    
    
        public static void vergelijken(int aantalDagen, AnchorPane gev21D) throws SQLException{
            
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel(Language.getTranslationString("TLK315"));
        //creating the chart
        final BarChart<String, Number> bc
                = new BarChart<>(xAxis, yAxis);

        bc.setTitle(Language.getTranslationString("TLK316") + ", " + aantalDagen + " " + Language.getTranslationString("TLK317"));
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName(bagGev);
        //populating the series with data
        int j = 0;
        int[] gevondenKoffers = aantalGevonden(aantalDagen);
        for (int i = 0; i < aantalDagen; i++) {
            j++;
            String nummer = Integer.toString(j);
            series.getData().add(new XYChart.Data(nummer, gevondenKoffers[i]));
        }
        j = 0;
        int[] verlorenKoffers = aantalVerloren(aantalDagen);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(bagVer);
        //populating the series with data
            for (int i = 0; i < aantalDagen; i++) {
                j++;
                String nummer = Integer.toString(j);
                series2.getData().add(new XYChart.Data(nummer, verlorenKoffers[i]));
        
            }
        
        
        bc.getData().addAll(series, series2);
        gev21D.getChildren().setAll();
        gev21D.getChildren().setAll(bc);
        
        
        bc.prefWidthProperty().bind(gev21D.widthProperty());
        bc.prefHeightProperty().bind(gev21D.heightProperty());
        
    }

    public static int[] aantalGevonden(int aantalDagen) throws SQLException {
        int aantalKoffers = 0;
        String date_found;
        int[] aantalGevonden = new int[aantalDagen];

        resultSet = db.executeResultSetQuery("SELECT `Date` FROM `bagage` WHERE IsReturned = '1'");
        while (resultSet.next()) {
            
            for (int i = 0; i < aantalDagen; i++) {

                date_found = resultSet.getString("Date");

                String datadb = date_found;

                Calendar c1 = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                c1.add(Calendar.DATE, -i);
                String date1 = sdf1.format(c1.getTime());
                System.out.println(date1);
                if (date1.compareTo(datadb) == 0) {
                    aantalGevonden[i]++;
                    break;
                }

                System.out.println(aantalKoffers);
                aantalKoffers = 0;
            }
        }
        return aantalGevonden;
    }
    public static int[] aantalVerloren(int aantalDagen) throws SQLException {
        int aantalKoffers = 0;
        String date_found;
        int[] aantalVerloren = new int[aantalDagen];

        resultSet = db.executeResultSetQuery("SELECT `Date` FROM `bagage` WHERE IsReturned = '0'");
        while (resultSet.next()) {
            
            for (int i = 0; i < aantalDagen; i++) {

                date_found = resultSet.getString("Date");

                String datadb = date_found;

                Calendar c1 = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                c1.add(Calendar.DATE, -i);
                String date1 = sdf1.format(c1.getTime());
                System.out.println(date1);
                if (date1.compareTo(datadb) == 0) {
                    aantalVerloren[i]++;
                    break;
                }

                System.out.println(aantalKoffers);
                aantalKoffers = 0;
            }
        }
        return aantalVerloren;
    }
}
