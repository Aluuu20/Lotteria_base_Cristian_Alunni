/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;


import java.util.Random;

/**
 *
 * @author Alu
 */
public class Giocatore extends Thread{
    private static final Scanner scelta = new Scanner(System.in);

    private int idGiocatore;
    // attributi
    private  String nomeGiocatore;
    private  Estrazione estrazione;

    /**
    * 
    * Metodo costruttore
    * @param idGiocatore codice del giocatore
    * @param estrazione riferimento dell'oggetto Estrazione
    */
    public Giocatore(int idGiocatore, Estrazione estrazione) {
       // inizializzazione attributi
       this.idGiocatore= idGiocatore;
       this.estrazione = estrazione;
    }

    public int numeroInput(){
        synchronized(scelta){
            System.out.print("Il giocatore " + idGiocatore + " inserisca il numero: ");
            int numero = scelta.nextInt();
            return numero;
        }
    }
    
    
    
    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
       // scela del numero da giocare
      int numero = numeroInput();
       
       //System.out.println("scelta: " + scelta);
       // dati giocatore
       // System.out.println("id giocatore: " + idGiocatore + " INIZIO.\t" );
       // verifica del risutlato
       //conto alla rovescia
       
       // stampa fine verifica
       estrazione.verifica(numero, idGiocatore);
       // stampa fine verifica
           

    }
}
