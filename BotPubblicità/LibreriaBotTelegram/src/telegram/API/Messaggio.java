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
    int messageID;
    int chatID;
    String nomeUtente;
    String text;
    
    public Messaggio(){
        messageID=0;
        chatID=0;
        nomeUtente="";
        text="";
    }
    
    public Messaggio(int messageID, int chatID, String nomeUtente, String text){
        this.messageID=messageID;
        this.chatID=chatID;
        this.nomeUtente=nomeUtente;
        this.text=text;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
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
