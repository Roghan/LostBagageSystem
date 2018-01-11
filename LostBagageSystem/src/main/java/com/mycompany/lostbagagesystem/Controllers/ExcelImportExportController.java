package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.LostAndFoundLuggageInventory;
import com.mycompany.lostbagagesystem.models.ColourPicker;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Cell;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class ExcelImportExportController implements Initializable {

    @FXML
    private ToggleGroup Filter;

    @FXML
    private TextField txtFilter;

    @FXML
    private TableView<LostAndFoundLuggageInventory> bagage;

    @FXML
    private ToggleGroup txtBoxFilter;

    @FXML
    private MenuButton filterBox;

    private String registrationNr;
    private Date dateFound;
    private String timeFound;
    private String luggageType;
    private String brand;
    private String flightNumber;
    private String luggageTag;
    private String locationFound;
    private String mainColor;
    private String secondColor;
    private String size;
    private String weight;
    private String passNameAndCity;
    private String charateristics;
    private boolean imp = false;
    private XSSFWorkbook workbook;

    private Time time;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void dbTableFill(ActionEvent event) {

    }

    @FXML
    public void setTxtFilter(ActionEvent event) {

    }

    public void getDataFormDatabase() throws FileNotFoundException, IOException, SQLException {

        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row;
        String[] data = new String[]{};
        ObservableList<LostAndFoundLuggageInventory> bagagetabel = FXCollections.observableArrayList();

        for (int i = 5; i < sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            registrationNr = row.getCell(0).getStringCellValue();
            System.out.println(registrationNr);
            XSSFCell cellDate = row.getCell(1);
            String date = cellDate.toString();
            XSSFCell cellTime = row.getCell(2);
            timeFound = cellTime.toString();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                dateFound = formatter.parse(date);
            } catch (ParseException ex) {

            }

            if (timeFound.equals("31-Dec-1899")) {
                // compute time in the day in seconds
                int secsInDay = (int) ((cellTime.getDateCellValue().getTime() / 1000) % 86400);
                if (secsInDay < 0) {
                    secsInDay += 86400;
                }
                // compute hours, minutes and format the string
                int hours = secsInDay / 3600;
                int minutes = (secsInDay % 3600) / 60;
                timeFound = String.format("%02d:%02d", hours, minutes);

                //timeFound = row.getCell(2).getNumericCellValue();
                luggageType = row.getCell(3).getStringCellValue();
                brand = row.getCell(4).getStringCellValue();
                flightNumber = row.getCell(5).getStringCellValue();
                luggageTag = row.getCell(6).getStringCellValue();
                locationFound = row.getCell(7).getStringCellValue();
                String color = row.getCell(8).getStringCellValue();
                mainColor = ColourPicker.GetColourExcel(color);
                color = row.getCell(8).getStringCellValue();
                secondColor = ColourPicker.GetColourExcel(color);
                size = row.getCell(10).getStringCellValue();
                weight = row.getCell(11).getStringCellValue();
                passNameAndCity = row.getCell(12).getStringCellValue();
                charateristics = row.getCell(13).getStringCellValue();

                bagagetabel.add(new LostAndFoundLuggageInventory(registrationNr, dateFound, timeFound, luggageType, brand, flightNumber, luggageTag, locationFound, mainColor, secondColor, size, weight, passNameAndCity, charateristics));

                if (imp) {
                    sendToDatabase();
                } else {

                    for (int j = 0; j < bagage.getColumns().size(); j++) {
                        TableColumn column = (TableColumn) bagage.getColumns().get(j);
                        column.setCellValueFactory(new PropertyValueFactory(column.getId()));
                    }

                    bagage.setItems(bagagetabel);
                }

            }

        }

    }

    public void sendToDatabase() throws SQLException {
        // Making a new prepared statement 
        PreparedStatement myStmt = null;
        Connection conn = null;
        ConnectDB db = new ConnectDB();
        int numberAffected = 0;

        // Updates persoonsgegevens
        String persoonsgegevens = "INSERT INTO `bagage` "
                + "(`State`, `Date`, `Time`, `Labelnumber`, `Type`, "
                + "`Brand`,`Color1`, `Color2`, `Characteristics`, `Passnameandcity`,`RegistrationNr`, `Flightnumber`) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.getDBConnection();
            myStmt = conn.prepareStatement(persoonsgegevens);
            // Filling in the question marks from the query
            myStmt.setString(1, "Found"); //?
            myStmt.setDate(2, (java.sql.Date) dateFound);
            myStmt.setString(3, timeFound);
            myStmt.setString(4, luggageTag);
            myStmt.setString(5, luggageType);
            myStmt.setString(6, brand);
            myStmt.setString(7, mainColor);
            myStmt.setString(8, secondColor);
            myStmt.setString(9, charateristics);
            myStmt.setString(10, passNameAndCity);
            myStmt.setString(11, registrationNr);
            myStmt.setString(12, flightNumber);

            // Execute INSERT sql statement
            numberAffected = myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Closing the prepared statement for memory purposes
            if (myStmt != null) {
                myStmt.close();
            }
            // Closing the database connection for memory purposes
            if (conn != null) {
                conn.close();
            }
        }

        System.out.println(numberAffected);

    }

    public void importExcelFile(ActionEvent event) throws IOException, FileNotFoundException, SQLException {
        imp = false;
        workbook = new XSSFWorkbook(new FileInputStream(MainApp.selectFileToOpen()));
        getDataFormDatabase();

    }

    public void importTable(ActionEvent event) throws IOException, FileNotFoundException, SQLException {
        imp = true;
        getDataFormDatabase();

    }
}
