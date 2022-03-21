/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BosnianBot;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegram.API.*;

/**
 *
 * @author matte
 */
public class ThreadInvio extends Thread {

    TelegramApi api;
    Condivisa condivisa;
    XMLCoordinate coords;

    public ThreadInvio(Condivisa c) {
        api = new TelegramApi();
        condivisa = c;
        coords = new XMLCoordinate();
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadInvio.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (condivisa.hasMessaggio()) {
                Messaggio mess = condivisa.getMessaggio();
                String testo = "";
                String messaggio = mess.getText();

                //controllo
                if (mess.getType() == 1) {//messaggio di risposta a utente                    
                    if (!messaggio.equals("")) {
                        if (messaggio.startsWith("/")) {
                            if (messaggio.toUpperCase().startsWith("/CITTA ")) {
                                String query = messaggio.substring(7);
                                try {
                                    if (coords.getXMLToCSV(query, mess.getChatID(), mess.getNomeUtente())) {
                                        testo = "posizione salvata";
                                    } else {
                                        testo = "posizione non trovata";
                                    }
                                } catch (IOException ex) {
                                    Logger.getLogger(ThreadInvio.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                testo = "comando non valido";
                            }
                        } else {
                            if (messaggio.equalsIgnoreCase("bosnia")) {
                                testo = "BOSNIA!";
                            }
                        }

                        //invio
                        if (!testo.equals("")) {
                            try {
                                api.sendMessage(testo, mess.getChatID());
                            } catch (IOException ex) {
                                Logger.getLogger(ThreadInvio.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else if (mess.getType() == 2) {//messaggi pubblicitari
                    testo=condivisa.getTestoPubblicita();
                    try {
                        api.sendMessage(testo, mess.getChatID());
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadInvio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }
    }
}
