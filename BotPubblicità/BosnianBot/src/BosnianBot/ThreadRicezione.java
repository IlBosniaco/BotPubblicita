/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BosnianBot;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import telegram.API.*;

/**
 *
 * @author matte
 */
public class ThreadRicezione extends Thread{
    TelegramApi api;
    JsonToMessaggio parser;
    int  offset;
    boolean first;
    
    public ThreadRicezione(){
        api = new TelegramApi();
        parser = new JsonToMessaggio();
        offset=0;
        first=true;
    }
    
    @Override
    public void run(){
        while(true){
            try {                
                JSONObject json = api.getUpdates(offset);//passo offset
                List<Messaggio> messaggi = parser.JsonParser(json);
                if(!messaggi.isEmpty()){//controllo vuoto
                    //con offset cancello i messaggi precedenti da getUpdates
                    offset =Integer.parseInt(messaggi.get(messaggi.size()-1).getUpdateID())+1;//prendo il valore di id e lo setto come offset
                    if(!first)
                        Condivisa.getIstance().AddMessaggi(messaggi); 
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                       
            try {
                if(!first)
                    Thread.sleep(4000);
                else
                    Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(first)
                first=false;
        }
    }
}
