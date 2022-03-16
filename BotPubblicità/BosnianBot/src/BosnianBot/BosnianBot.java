/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BosnianBot;

//per importare serve file jar da inserire tra le librerie
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matte
 */
public class BosnianBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*String jsonstring="{mess:'ciao mondo'}";
        JSONObject obj = new JSONObject(jsonstring);
        String ciao=obj.getString("mess");
        System.out.println(ciao);
        TelegramApi cioooooo =  new TelegramApi();
        cioooooo.Test();*/

        //per leggere da console
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String text = reader.readLine();
        Condivisa c =  new Condivisa();
        ThreadInvio ti = new ThreadInvio(c);
        ThreadRicezione tr = new ThreadRicezione(c);
        
        tr.start();
        ti.start();
        

        try {
            tr.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BosnianBot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ti.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BosnianBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
