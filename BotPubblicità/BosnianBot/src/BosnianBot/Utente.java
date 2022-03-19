/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BosnianBot;

/**
 *
 * @author matte
 */
public class Utente {
    Coordinate coor;
    String chatID;
    String nomeUtente;
    
    public Utente(){
        coor=new Coordinate();
        chatID="";
        nomeUtente="";
    }

    public Utente(Coordinate coor, String chatID, String nomeUtente) {
        this.coor = coor;
        this.chatID = chatID;
        this.nomeUtente = nomeUtente;
    }

    public Coordinate getCoor() {
        return coor;
    }

    public void setCoor(Coordinate coor) {
        this.coor = coor;
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
    
    
}
