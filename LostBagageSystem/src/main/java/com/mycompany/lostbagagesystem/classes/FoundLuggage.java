/*This Class is the main class for the found luggage Form in the Lost Bagage System
 */
package com.mycompany.lostbagagesystem.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class FoundLuggage {

    private String registrationNumber;
    private String dateFound;
    private String timeFound;
    private String luggageType;
    private String brand;
    private String Collor;



    public static List<FoundLuggage> importFoundLuggageFromExcel(String fileName) {
        //create a new empty found luggage list
        List<FoundLuggage> luggageList = new ArrayList<>();

        //Todo process the excel file and build a list of found luggage
        
        //add some dummy dound luggage
        luggageList.add(new FoundLuggage());
        luggageList.add(new FoundLuggage());
        
        return luggageList;

    }

}
