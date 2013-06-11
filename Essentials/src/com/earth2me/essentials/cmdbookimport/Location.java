/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.earth2me.essentials.cmdbookimport;

/**
 *
 * @author rymate
 */
public class Location implements java.io.Serializable {

    private String world;
    private String name;
    private String locYaw;
    private String locZ;
    private String locY;
    private String locX;
    private String creator;
    private String locPitch;

    public void setWorld(String string) {
        world = string;
    }

    public void setName(String string) {
        name = string;
    }

    public void setCreator(String string) {
        creator = string;
    }

    public void setLocX(String string) {
        locX = string;
    }

    public void setLocY(String string) {
        locY = string;
    }

    public void setLocZ(String string) {
        locZ = string;
    }

    public void setYaw(String string) {
        locYaw = string;
    }

    public void setPitch(String string) {
        locPitch = string;
    }
    
    @Override
    public String toString() {
        return "Locations [name= " + name
                        + ", world=" + world + ", creator=" + creator +
                        ", LocX=" + locX + ", LocY=" + locY + 
                        ", LocZ=" + locZ + ", LocPitch=" + locPitch + 
                        ", LocYaw=" + locYaw + "]";
    }
}
