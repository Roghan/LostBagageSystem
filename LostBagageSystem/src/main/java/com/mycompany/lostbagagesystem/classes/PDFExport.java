/*Class voor het exporteren van een PDF
 */
package com.mycompany.lostbagagesystem.classes;

import com.mycompany.lostbagagesystem.MainApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
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

    public void addPage(String staat, String datum, String tijd,
            String voorletters, String tussenvoegsel, String achternaam,
            String straat, String huisnummer, String postcode,
            String woonplaats, String vStraatnaam, String vHuisnummer, String vPostcode,
            String vPlaats, String hotelnaam, String email, String telefoon, 
            String mobiel, String vluchtnummer, String van, 
            String naar, String labelnummer,
            String typeBagage, String merk, String kleur1, String kleur2, 
            String bijzondereKenmerken) throws IOException {
        doc.addPage(page);
        PDImageXObject image = PDImageXObject.createFromFile("assets//formPag1.png", doc);
        content.drawImage(image, 0, 0);
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA_BOLD, 36);
        content.newLineAtOffset(335, 742);
        content.showText("Luggage form");
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 642);
        content.showText(language.getTranslationString("TLK300"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 642);
        content.showText(staat);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 591);
        content.showText(language.getTranslationString("TLK301"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 591);
        content.showText(datum);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 540);
        content.showText(language.getTranslationString("TLK302"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 540);
        content.showText(tijd);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 485);
        content.showText(language.getTranslationString("TLK303"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 485);
        content.showText(voorletters);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(265, 485);
        content.showText(tussenvoegsel);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(365, 485);
        content.showText(achternaam);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 440);
        content.showText(language.getTranslationString("TLK18"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 440);
        content.showText(straat);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(265, 440);
        content.showText(huisnummer);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 410);
        content.showText(language.getTranslationString("TLK21"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 410);
        content.showText(postcode);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 382);
        content.showText(language.getTranslationString("TLK22"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 382);
        content.showText(woonplaats);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 319);
        content.showText(language.getTranslationString("TLK304"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 319);
        content.showText(vStraatnaam);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(265, 319);
        content.showText(vHuisnummer);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 290);
        content.showText(language.getTranslationString("TLK305"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 290);
        content.showText(vPostcode);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 261);
        content.showText(language.getTranslationString("TLK306"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 261);
        content.showText(vPlaats);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(265, 201);
        content.showText(hotelnaam);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 201);
        content.showText(language.getTranslationString("TLK307"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 201);
        content.showText(email);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 148);
        content.showText(language.getTranslationString("TLK26"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 148);
        content.showText(telefoon);
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, 96);
        content.showText(language.getTranslationString("TLK27"));
        content.endText();
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(165, 96);
        content.showText(mobiel);
        content.endText();
        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(165, 742);
//        content.showText(vluchtnummer);
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("Luggage form");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(165, 742);
//        content.showText(van);
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("Luggage form");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(165, 742);
//        content.showText(naar);
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("Luggage form");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(165, 742);
//        content.showText(labelnummer);
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("Luggage form");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(165, 742);
//        content.showText(typeBagage);
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("Luggage form");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(165, 742);
//        content.showText(merk);
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("Luggage form");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText(kleur1);
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("Luggage form");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText(kleur2);
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText("Luggage form");
//        content.endText();
//        
//        content.beginText();
//        content.setFont(PDType1Font.HELVETICA, 12);
//        content.newLineAtOffset(50, 742);
//        content.showText(bijzondereKenmerken);
//        content.endText();
        
        
        
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
        
        
        
        
        
        
        

        
        
        
    }

    public void savePDF() {
        File selectedFile = MainApp.selectFileToSave();

        if (selectedFile != null) {
            try {
                fileName = selectedFile.getAbsolutePath();

                content.close(); //Makes sure the ContentStream is Closed before saving

                doc.save(fileName); //Saves The PDF

                doc.close(); //Cleans the Memory
            } catch (IOException ex) {
                Logger.getLogger(PDFExport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getSavedLabelText() {
        this.lableText = "Het bestand is opgeslagen in : " + fileName;

        return lableText;
    }

    public void addPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
