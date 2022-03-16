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
    List<Messaggio> messaggi;
    int lastMessageID;
    
    public Condivisa(){
        messaggi=new ArrayList<Messaggio>();
        lastMessageID=0;
    }
    
    public Condivisa(List<Messaggio> messaggi, int id){
        this.messaggi=messaggi;
        lastMessageID=id;
    }
    
    public void AddMessaggi(List<Messaggio> messaggi){
        this.messaggi.addAll(messaggi);
    }
    
    public void setID(int id){
        lastMessageID=id;
    }
    
    public int getID(){
        return lastMessageID;
    }
    
    public void setNewerID(int id){
        if(lastMessageID<id)
            lastMessageID=id;
    }
    
    public Messaggio getMessaggio(){
        if(!messaggi.isEmpty())
            return messaggi.remove(0);
        else
            return new Messaggio();
    }
    
    public boolean hasMessaggio(){
        if(messaggi.isEmpty())
            return false;
        else
            return true;
    }
}
