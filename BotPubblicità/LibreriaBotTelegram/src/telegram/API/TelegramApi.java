package telegram.API;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegram.API;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author matte
 */
public class TelegramApi {

    String BotName = "BosnianBot";
    String BotKey = "5246475403:AAEA525FaiDiwwwUGLOHw4cD36q4kOEw_kU";
    
    public TelegramApi(){
        
    }
    
    public TelegramApi(String name, String key){
        BotName=name;
        BotKey=key;
    }

    public String getBotName() {
        return BotName;
    }

    public String getBotKey() {
        return BotKey;
    }

    public JSONObject getUpdates() throws IOException, JSONException {
        String temp = "";
        URL url = new URL("https://api.telegram.org/bot" + BotKey + "/getUpdates");
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) {//200 indica che la richiesta è andata a buon fine
            Scanner scan = new Scanner(url.openStream());
            while (scan.hasNext()) {
                temp += scan.nextLine();
            }
        }
        JSONObject json = new JSONObject(temp);
        return json;
    }
    
    public JSONObject getUpdates(int offset) throws IOException, JSONException {
        String temp = "";
        URL url = new URL("https://api.telegram.org/bot" + BotKey + "/getUpdates?offset="+offset);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) {//200 indica che la richiesta è andata a buon fine
            Scanner scan = new Scanner(url.openStream());
            while (scan.hasNext()) {
                temp += scan.nextLine();
            }
        }
        JSONObject json = new JSONObject(temp);
        return json;
    }

    public void sendMessage(String message, int id) throws MalformedURLException, IOException {
        URL url = new URL("https://api.telegram.org/bot" + BotKey + "/sendMessage?chat_id=" + id + "&text=" + message);
        URLConnection con = url.openConnection();
        InputStream is = new BufferedInputStream(con.getInputStream());
    }
    
}
