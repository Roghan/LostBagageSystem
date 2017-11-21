/*Class that runs a PDF export Using PDFBox
 */
package com.mycompany.lostbagagesystem.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.stage.FileChooser;
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

    public void addPage() throws IOException {

        doc.addPage(page);
        PDImageXObject image = PDImageXObject.createFromFile("assets\\corendonlogo.jpg", doc);

        content.drawImage(image, 25, 500);

    }

    public void savePDF() throws IOException {

        FileChooser fileChooser = new FileChooser();
        File selceltedFile = fileChooser.showSaveDialog(null);

        if (selceltedFile != null) {
            fileName = selceltedFile.getAbsolutePath();

            content.close(); //Makes sure the ContentStream is Closed before saving
            
            doc.save(fileName + ".pdf"); //Saves The PDF
            
            doc.close(); //Cleans the Memory
        }

    }

    public String getSavedLabelText() {
        this.lableText = "Het bestand is opgeslagen in : " + fileName;

        return lableText;
    }

}
