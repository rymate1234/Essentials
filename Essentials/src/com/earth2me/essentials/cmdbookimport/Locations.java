/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.earth2me.essentials.cmdbookimport;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rymate
 */
public class Locations implements java.io.Serializable {

    List locations = new ArrayList<Locations>();
    
    
    public void add(Location loc) {
        locations.add(loc);
    }
    
}
