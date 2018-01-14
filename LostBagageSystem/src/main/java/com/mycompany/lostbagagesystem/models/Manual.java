/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.models;

import com.mycompany.lostbagagesystem.MainApp;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javafx.application.HostServices;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Manual {
    
    public static void openPFD() throws IOException {
        
        File file = new File("assets//man.pdf");
        
        Desktop.getDesktop().open(file.getAbsoluteFile());
        
    }
    
}
