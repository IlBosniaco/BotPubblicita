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
    Condivisa condivisa;
    int offset;
    
    public ThreadRicezione(Condivisa c){
        api = new TelegramApi();
        parser = new JsonToMessaggio();
        condivisa=c;
        offset=0;
    }
    
    @Override
    public void run(){
        while(true){
            try {                
                JSONObject json = api.getUpdates(offset);//passo offset
                List<Messaggio> messaggi = parser.JsonParser(json);
                if(!messaggi.isEmpty()){//controllo vuoto
                    //con offset cancello i messaggi precedenti da getUpdates
                    offset =messaggi.get(messaggi.size()).getMessageID();//prendo il valore di id e lo setto come offset
                    condivisa.AddMessaggi(messaggi); 
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                       
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
