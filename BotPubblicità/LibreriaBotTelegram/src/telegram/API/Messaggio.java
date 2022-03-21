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
    int type;
    String updateID;
    String chatID;
    String nomeUtente;
    String text;
    
    public Messaggio(){
        type=0;
        updateID="";
        chatID="";
        nomeUtente="";
        text="";
    }
    
    public Messaggio(int type, String messageID, String chatID, String nomeUtente, String text){
        this.type=type;
        this.updateID=messageID;
        this.chatID=chatID;
        this.nomeUtente=nomeUtente;
        this.text=text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUpdateID() {
        return updateID;
    }

    public void setUpdateID(String updateID) {
        this.updateID = updateID;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
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
