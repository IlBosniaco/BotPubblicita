/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BosnianBot;

import java.io.IOException;
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
    
    public ThreadRicezione(){
        
    }
    
    @Override
    public void run(){
        while(true){
            try {
                JSONObject json = api.getUpdates();
                parser.JsonParser(json);
            } catch (IOException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                       
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadRicezione.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
