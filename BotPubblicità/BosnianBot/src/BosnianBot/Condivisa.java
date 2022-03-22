/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BosnianBot;

import java.util.ArrayList;
import java.util.List;
import telegram.API.*;
/**
 *
 * @author matte
 */
public class Condivisa {
    private static Condivisa istance=null;
    private List<Messaggio> messaggi;
    private int lastMessageID;
    private String testoPubblicita;
    
    public Condivisa(){
        messaggi=new ArrayList<Messaggio>();
        lastMessageID=0;
        testoPubblicita="";
    }
    
    public Condivisa(List<Messaggio> messaggi, int id, String testoPubblicita){
        this.messaggi=messaggi;
        lastMessageID=id;
        this.testoPubblicita=testoPubblicita;
    }
    
    public static Condivisa getIstance() {
        if (istance == null) {
            synchronized (Condivisa.class) {
                if (istance == null) {
                    istance = new Condivisa();
                }
            }
        }
        return istance;
    }
    
    synchronized public void AddMessaggi(List<Messaggio> messaggi){
        this.messaggi.addAll(messaggi);
    }
    
    synchronized public void setID(int id){
        lastMessageID=id;
    }
    
    synchronized public int getID(){
        return lastMessageID;
    }
    
    synchronized public void setNewerID(int id){
        if(lastMessageID<id)
            lastMessageID=id;
    }
    
    synchronized public Messaggio getMessaggio(){
        if(!messaggi.isEmpty())
            return messaggi.remove(0);
        else
            return new Messaggio();
    }
    
    synchronized public boolean hasMessaggio(){
        if(messaggi.isEmpty())
            return false;
        else
            return true;
    }

    synchronized public String getTestoPubblicita() {
        return testoPubblicita;
    }

    synchronized public void setTestoPubblicita(String testoPubblicita) {
        this.testoPubblicita = testoPubblicita;
    }
   
}
