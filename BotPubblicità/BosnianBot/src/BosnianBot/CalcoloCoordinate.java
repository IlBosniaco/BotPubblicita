/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BosnianBot;

/**
 *
 * @author matte
 */
public class CalcoloCoordinate {
    
    public CalcoloCoordinate(){
        
    }
    
    public float CalcoloDistanzaKM(float lat1, float lat2, float lon1, float lon2) {
        int R = 6371; // Radius of the earth in km
        float dLat = deg2rad(lat2 - lat1);  // deg2rad below
        float dLon = deg2rad(lon2 - lon1);
        float a
                = (float) (Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2));
        float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
        float d = R * c; // Distance in km
        return d;
    }

    public float deg2rad(float deg) {
        return (float) (deg * (Math.PI / 180));
    }
}
