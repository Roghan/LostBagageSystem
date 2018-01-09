package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.LostAndFoundLuggageInventory;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
    private Double timeFound;
    private String luggageType;
    private String brand;
    private String flightNumber;
    private int luggageTag;
    private String locationFound;
    private String mainColor;
    private String secondColor;
    private String size;
    private String weight;
    private String passNameAndCity;
    private String charateristics;
    
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
    
    
    

    public void importExcelFile(ActionEvent event) throws FileNotFoundException, IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(MainApp.selectFileToOpen()));
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row;
        String[] data = new String[]{};
        ObservableList<LostAndFoundLuggageInventory> bagagetabel = FXCollections.observableArrayList();

        for (int i = 5; i < sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            registrationNr = row.getCell(0).getStringCellValue();
            System.out.println(registrationNr);
            dateFound = row.getCell(1).getDateCellValue();
            timeFound = row.getCell(2).getNumericCellValue();
            luggageType = row.getCell(3).getStringCellValue();
            brand = row.getCell(4).getStringCellValue();
            flightNumber = row.getCell(5).getStringCellValue();
            luggageTag = (int) row.getCell(6).getNumericCellValue();
            locationFound = row.getCell(7).getStringCellValue();
            mainColor = row.getCell(8).getStringCellValue();
            secondColor = row.getCell(9).getStringCellValue();
            size = row.getCell(10).getStringCellValue();
            weight = row.getCell(11).getStringCellValue();
            passNameAndCity = row.getCell(12).getStringCellValue();
            charateristics = row.getCell(13).getStringCellValue();
            
            

            bagagetabel.add(new LostAndFoundLuggageInventory(registrationNr, dateFound, timeFound, luggageType, brand, flightNumber, luggageTag,
                    locationFound, mainColor, secondColor, size, weight, passNameAndCity, charateristics));

            for (int j = 0; j < bagage.getColumns().size(); j++) {
                TableColumn column = (TableColumn) bagage.getColumns().get(j);
                column.setCellValueFactory(new PropertyValueFactory(column.getId()));
            }

        }

        bagage.setItems(bagagetabel);

    }

}
