/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.earth2me.essentials.cmdbookimport;

import com.earth2me.essentials.IEssentials;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class CommandBookWarpsImporter
{
	String csvFile;
	Locations storage;
	private final IEssentials ess;

	public CommandBookWarpsImporter(String homescsv, IEssentials ess)
	{
		this.csvFile = homescsv;
		this.ess = ess;
	}

	public void parse()
	{
		BufferedReader br = null;
		String line = "";
		String seperator = ",";
		storage = new Locations();

		try
		{
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null)
			{

				// use comma as separator
				line = line.replaceAll("\"", "");

				String[] location = line.split(seperator);

				Location loc;
				loc = new Location(Bukkit.getWorld(location[1]),
								   Double.parseDouble(location[3]),
								   Double.parseDouble(location[4]),
								   Double.parseDouble(location[5]),
								   Float.parseFloat(location[6]),
								   Float.parseFloat(location[7]));


				System.out.println(loc);
				ess.getWarps().setWarp(location[0], loc);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception ex)
		{
			Logger.getLogger(CommandBookWarpsImporter.class.getName()).log(Level.SEVERE, null, ex);
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
