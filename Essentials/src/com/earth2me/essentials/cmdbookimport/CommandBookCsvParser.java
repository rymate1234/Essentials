/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.earth2me.essentials.cmdbookimport;

import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.UserData;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CommandBookCsvParser {

    String csvFile;
    Locations storage;
    private final IEssentials ess;

    public CommandBookCsvParser(String homescsv, IEssentials ess) {
        this.csvFile = homescsv;
        this.ess = ess;
    }

    public void parse(Player player) {

        BufferedReader br = null;
        String line = "";
        String seperator = ",";
        storage = new Locations();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
				line = line.replaceAll("\"", "");
                String[] location = line.split(seperator);
                if (location[0] == player.getName()) {
                    Location loc;
                    loc = new Location(Bukkit.getWorld(location[1]) , 
                            Double.parseDouble(location[3]),
                            Double.parseDouble(location[4]), 
                            Double.parseDouble(location[5]), 
                            
                            Float.parseFloat(location[6]), 
                            Float.parseFloat(location[7]));
                    

                    System.out.println(loc);
                    
                    ess.getUser(player.getName()).setHome("home", loc);
					ess.getUser(player.getName()).saveData();
					ess.getUser(player.getName()).loadData();
                    
                    break;

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
