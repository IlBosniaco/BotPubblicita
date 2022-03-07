/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegram.API;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author matte
 */
public class JsonToMessaggio {
    
    public JsonToMessaggio(){
        
    }
    
    public List<Messaggio> JsonParser(JSONObject json){
        List<Messaggio> messages=new ArrayList<>();
        JSONArray jArray = json.getJSONArray("result");
        for (int i = 0; i < jArray.length(); i++) {
            int messageID=Integer.parseInt(jArray.getJSONObject(i).getJSONObject("message").get("message_id").toString());
            int chatID=Integer.parseInt(jArray.getJSONObject(i).getJSONObject("message").getJSONObject("chat").get("id").toString());
            String nomeUtente=jArray.getJSONObject(i).getJSONObject("message").getJSONObject("chat").get("first_name").toString();
            String text = jArray.getJSONObject(i).getJSONObject("message").get("text").toString();
            messages.add(new Messaggio(messageID,chatID,nomeUtente,text));  
        }
        
        return messages;
    }
}
