/*Class voor het exporteren van een PDF
 */
package com.mycompany.lostbagagesystem.classes;

import com.mycompany.lostbagagesystem.MainApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
=======
>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class PDFExport {

    private final PDDocument doc = new PDDocument(); //Makes a new PDF Document

    private final PDPage page = new PDPage(); //Makes a new page

    private final PDPageContentStream content = new PDPageContentStream(doc, page); //Opens the Content stream

    private String fileName; //The Directory the file will get

    private String lableText; //StatusMessage

    public PDFExport() throws FileNotFoundException, IOException {

    }

<<<<<<< HEAD
    public void addPage(String datum, String tijd,
            String naamEnStad, String straat, String huisnummer, String postcode,
            String woonplaats, String vStraatnaam, String vHuisnummer, String vPostcode,
            String vPlaats, String hotelnaam, String email, String telefoon, 
            String mobiel) throws IOException {
        doc.addPage(page);
        PDImageXObject image = PDImageXObject.createFromFile("assets//formPag.png", doc);
        content.drawImage(image, 0, 0);
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA_BOLD, 32);
        content.newLineAtOffset(368, 738);
        content.showText("DHL");
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 643);
        content.showText((language.getTranslationString("TLK301") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 643);
        content.showText(datum);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 590);
        content.showText((language.getTranslationString("TLK302") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 590);
        content.showText(tijd);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 537);
        content.showText((language.getTranslationString("TLK309") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 537);
        content.showText(naamEnStad);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 484);
        content.showText((language.getTranslationString("TLK18") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 484);
        content.showText(straat);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(372, 484);
        content.showText(huisnummer);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 451);
        content.showText((language.getTranslationString("TLK22") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 451);
        content.showText(woonplaats);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 419);
        content.showText((language.getTranslationString("TLK21") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 419);
        content.showText(postcode);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 356);
        content.showText((language.getTranslationString("TLK308") + ":"));
        content.endText();
                               
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 356);
        content.showText(hotelnaam);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 324);
        content.showText((language.getTranslationString("TLK304") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 324);
        content.showText(vStraatnaam);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(372, 324);
        content.showText(vHuisnummer);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 292);
        content.showText((language.getTranslationString("TLK305") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 292);
        content.showText(vPlaats);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 259);
        content.showText((language.getTranslationString("TLK306") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 259);
        content.showText(vPostcode);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 196);
        content.showText((language.getTranslationString("TLK307") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 196);
        content.showText(email);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 143);
        content.showText((language.getTranslationString("TLK26") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 143);
        content.showText(telefoon);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 90);
        content.showText((language.getTranslationString("TLK27") + ":"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(172, 90);
        content.showText(mobiel);
        content.endText();
        
        
//        String[] array = {"%TLK50"};
//        System.out.println(array[0]);
        
//        int[] x = new int[40];
//        x[0] = 50;
//        x[1] = 50;
//        x[2] = 50;
//        x[3] = 50;
//        x[4] = 50;
//        x[5] = 50;
//        x[6] = 50;
//        x[7] = 50;
//        x[8] = 50;
//        x[9] = 50;
//        x[10] = 50;
//        x[11] = 50;
//        x[12] = 50;
//        x[13] = 50;
//        x[14] = 50;
//        x[15] = 50;
//        x[16] = 50;
//        x[17] = 50;
//        x[18] = 50;
//        x[19] = 50;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        x[20] = 165;
//        int[] y = new int[40];
//        int x2;
//        for (int i = 0; i < gegevens.length; i++) {
//            x2 = 165;
//            if (gegevens[i] == null) {
//                gegevens[i] = " ";
//            }
//            content.beginText();
//            content.setFont(PDType1Font.HELVETICA, 12);
//            content.newLineAtOffset(x2, 500);
//            content.showText(gegevens[i]);
//            content.endText();
//        }
=======
    public void addPage() throws IOException {

        doc.addPage(page);
        PDImageXObject image = PDImageXObject.createFromFile("assets//corendonlogo.jpg", doc);

        content.drawImage(image, 25, 500);

>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm
    }

    public void savePDF() throws IOException {
        File selectedFile = MainApp.selectFileToSave();

        if (selectedFile != null) {
            fileName = selectedFile.getAbsolutePath();

            content.close(); //Makes sure the ContentStream is Closed before saving

            doc.save(fileName); //Saves The PDF

            doc.close(); //Cleans the Memory
        }

    }

    public String getSavedLabelText() {
        this.lableText = "Het bestand is opgeslagen in : " + fileName;

        return lableText;
    }

}
