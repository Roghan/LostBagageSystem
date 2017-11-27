/*This Class is the Template for Loading FXML Files
 */
package com.mycompany.lostbagagesystem.classes;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class LoadFXML {

    @FXML
    private TableView tableView;

    @FXML
    private BorderPane borderPane;

    public BorderPane managerGevonden3Dagen() throws IOException {
        borderPane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermGevonden3Dagen.fxml"));
        return borderPane;

    }

}
