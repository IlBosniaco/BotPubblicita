/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegram.API;

/**
 *
 * @author matte
 */
public class Messaggio {
    int updateID;
    int chatID;
    String nomeUtente;
    String text;
    
    public Messaggio(){
        updateID=0;
        chatID=0;
        nomeUtente="";
        text="";
    }
    
    public Messaggio(int messageID, int chatID, String nomeUtente, String text){
        this.updateID=messageID;
        this.chatID=chatID;
        this.nomeUtente=nomeUtente;
        this.text=text;
    }

    public int getUpdateID() {
        return updateID;
    }

    public void setUpdateID(int updateID) {
        this.updateID = updateID;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
