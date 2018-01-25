package com.mycompany.lostbagagesystem.classes;

import com.mycompany.lostbagagesystem.models.bagageTabel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author User
 */
public class TableFillMan {

    private static ObservableList<bagageTabel> bagagetabel;

    public static ConnectDB db = new ConnectDB("lbs_database");
    public static ResultSet resultSet;

    @FXML
    public static void dbTableFill(int aantalDagen, TableView table, AnchorPane gev21D, String gevVer, int isGevonden) throws SQLException {

        int BagageID;
        String Date;
        String Time;
        String State;
        String Labelnumber;
        String Type;
        String Brand;
        int Color1;
        int Color2;
        String Characteristics;
        int IsReturned;
        String Airport;
        String Location;
        String Initial;
        String Insertion;
        String Surname;
        String Street;
        String Housenumber;
        String Zipcode;
        String City;
        String Email;
        String Phone1;
        String Phone2;
        String Flightnumber;
        String From;
        String To;
        String Vstreet;
        String Vhousenumber;
        String Vzipcode;
        String Vcity;
        String Hotelname;

        bagagetabel = FXCollections.observableArrayList();
        //SQL query
        resultSet = db.executeResultSetQuery("SELECT `BagageID`, "
                + " `State`, `Date`,`Time`, `Labelnumber`, "
                + "`Type`, `Brand`, `Color1`, "
                + "`Color2`, `Characteristics`, `IsReturned`, `Airport`, "
                + "`Location`, `Initial`, `Insertion`, `Surname`, "
                + "`Street`, `Housenumber`, `Zipcode`, `City`,"
                + " `Email`, `Phone1`, `Phone2`, `Flightnumber`,"
                + " `From`, `To`, `Vstreet`, `Vhousenumber`,"
                + " `Vzipcode`, `Vcity`, `Hotelname` FROM `bagage`");
        //Get all the results out of the database
        while (resultSet.next()) {
            BagageID = resultSet.getInt("BagageID");
            Date = resultSet.getString("Date");
            Time = resultSet.getString("Time");
            State = resultSet.getString("State");
            Labelnumber = resultSet.getString("Labelnumber");
            Type = resultSet.getString("Type");
            Brand = resultSet.getString("Brand");
            Color1 = resultSet.getInt("Color1");
            Color2 = resultSet.getInt("Color2");
            Characteristics = resultSet.getString("Characteristics");
            IsReturned = resultSet.getInt("IsReturned");
            Airport = resultSet.getString("Airport");
            Location = resultSet.getString("Location");
            Initial = resultSet.getString("Initial");
            Insertion = resultSet.getString("Insertion");
            Surname = resultSet.getString("Surname");
            Street = resultSet.getString("Street");
            Housenumber = resultSet.getString("Housenumber");
            Zipcode = resultSet.getString("Zipcode");
            City = resultSet.getString("City");
            Email = resultSet.getString("Email");
            Phone1 = resultSet.getString("Phone1");
            Phone2 = resultSet.getString("Phone2");
            Flightnumber = resultSet.getString("Flightnumber");
            From = resultSet.getString("From");
            To = resultSet.getString("To");
            Vstreet = resultSet.getString("Vstreet");
            Vhousenumber = resultSet.getString("Vhousenumber");
            Vcity = resultSet.getString("Vcity");
            Vzipcode = resultSet.getString("Vzipcode");
            Hotelname = resultSet.getString("Hotelname");

            //Current date - aantal dagen
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            c.add(Calendar.DATE, -aantalDagen);
            String date = sdf.format(c.getTime());
            //database date
            String datadb = Date + " " + Time;
            int returnBagage = IsReturned;

            //if currentdate -aantaldagen <= to database date than show
            if (date.compareTo(datadb) <= 0 && returnBagage == isGevonden) {
                bagagetabel.add(new bagageTabel(BagageID, Date, Time, State,
                        Labelnumber, Type, Brand, Color1, Color2, Characteristics,
                        IsReturned, Airport, Location, Initial, Insertion, Surname,
                        Street, Housenumber, Zipcode, City, Email, Phone1, Phone2,
                        Flightnumber, From, To, Vstreet, Vhousenumber, Vcity, Vzipcode,
                        Hotelname));

                for (int i = 0; i < table.getColumns().size(); i++) {
                    TableColumn column = (TableColumn) table.getColumns().get(i);
                    column.setCellValueFactory(new PropertyValueFactory(column.getId()));
                }
            }
        }

        table.setItems(bagagetabel);

        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel(Language.getTranslationString("TLK43"));
        //creating the chart
        final BarChart<String, Number> bc
                = new BarChart<>(xAxis, yAxis);

        bc.setTitle(gevVer + " " + Language.getTranslationString("TLK316") + " " +  aantalDagen + " " + Language.getTranslationString("TLK317"));
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName(Language.getTranslationString("TLK316"));
        //populating the series with data
        int j = 0;
        int[] aantalKoffers = aantalVerloren(aantalDagen, isGevonden);
        for (int i = 0; i < aantalDagen; i++) {
            j++;
            String nummer = Integer.toString(j);
            series.getData().add(new XYChart.Data(nummer, aantalKoffers[i]));
            System.out.println("nummer = " + nummer);
            System.out.println("aantal = " + aantalKoffers[i] + " IS GEVONDEN: " + isGevonden);
        }

        bc.getData().add(series);
        gev21D.getChildren().setAll();
        gev21D.getChildren().setAll(bc);

        bc.prefWidthProperty().bind(gev21D.widthProperty());
        bc.prefHeightProperty().bind(gev21D.heightProperty());

    }

    public static int[] aantalVerloren(int aantalDagen, int isGevonden) throws SQLException {
        int aantalKoffers = 0;
        String date_found;
        int[] aantalVerloren = new int[aantalDagen];

        resultSet = db.executeResultSetQuery("SELECT `Date` FROM `bagage` WHERE IsReturned = '" + isGevonden + "'");
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

                System.out.println(aantalKoffers + " Is gevonden: " + isGevonden);
                aantalKoffers = 0;
            }
        }
        return aantalVerloren;

    }
}
