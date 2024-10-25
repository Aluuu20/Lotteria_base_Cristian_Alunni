/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monica ciuchetti
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scelta del numero dei numeri da estrarre
        int numeroGiocatori = 3;
        // Istanza ed avvio del thread Estrazione
       Estrazione e = new Estrazione();
       e.start();

        // Istanza di alcuni thread Giocatore
       Giocatore [] giocatori = new Giocatore[numeroGiocatori];
       for(int i = 0; i< numeroGiocatori; i++){
           giocatori[i] = new Giocatore(i + 1, e);
           giocatori[i].start();
           
       }

        // Avvio dei thread Giocatori
        for(int i = 0; i< numeroGiocatori; i++){
            try{
                giocatori[i].join();
            }
            catch(InterruptedException err) {
                System.out.println("Thread interrotto: " + err.getMessage());
        }
        }
       
        e.stampaMatrice();
        e.stampaVincitori();
        // Comunicazione fine gioco
        System.out.println("FINE GIOCO");
    }
}
   