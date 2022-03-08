/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BosnianBot;

//per importare serve file jar da inserire tra le librerie
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.*;
import telegram.API.*;

/**
 *
 * @author matte
 */
public class BosnianBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        /*String jsonstring="{mess:'ciao mondo'}";
        JSONObject obj = new JSONObject(jsonstring);
        String ciao=obj.getString("mess");
        System.out.println(ciao);
        TelegramApi cioooooo =  new TelegramApi();
        cioooooo.Test();*/
        TelegramApi ciao = new TelegramApi();

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String text = reader.readLine();
        /*
        ciao.sendMessage("ciao",960830525);
        */
        XMLCoordinate coor = new XMLCoordinate();
        coor.getXMLToCSV("mariano", 960830525, "matteo");
        /*
        JSONObject json = ciao.getUpdates();
        JSONArray jArray = json.getJSONArray("result");

        for (int i = 0; i < jArray.length(); i++) {
           System.out.println(jArray.getJSONObject(i).getJSONObject("message").get("text").toString());
        }
        */

    }
    
}
