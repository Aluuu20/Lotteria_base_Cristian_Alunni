
package lotteria;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Alu
 */
public class Estrazione extends Thread {
    // attributi
    private int numero;
    private int vincitori[];
    private int numeroVincitori;
    private int matriceNumeri[][];
    /**
     * 
     * Metodo costruttore
     */   
    public Estrazione() {
        //dimensione matrice in input
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci dimensione matrice.");
        System.out.print("Righe: ");
        int r = input.nextInt();
        System.out.print("Colonne: ");
        int c = input.nextInt();
        matriceNumeri = new int [r][c];
        vincitori =new int[3];
        // popolamento matrice numeri estratti
        Random Rnumeri = new Random();
       
       for(int i = 0 ; i < matriceNumeri.length; i++){
            for(int j = 0; j< matriceNumeri.length; j++ ){
                
                matriceNumeri[i][j] = Rnumeri.nextInt(100);
            }
        }
       
      
        // inizializzazione array vincitori
        Set<Integer> numeriVincentiUnici = new HashSet<>(); //rendo i numeri vincenti unici
        int count = 0;
        while(count < vincitori.length){
            int numeroVincente = Rnumeri.nextInt(100);
                if(numeriVincentiUnici.add(numeroVincente)){
                    vincitori[count] = numeroVincente;
                    count++;
                }
        }
    
    }

   /**
    * 
    * Metodo per visualizzare la matrice dei numeri estratti
    */
    public void stampaMatrice() {
       // stampa matrice dei numeri estratti
       System.out.println("Numeri estratti dalla matrice: ");
        for(int i = 0 ; i < matriceNumeri.length; i++){
            for(int j = 0; j< matriceNumeri.length; j++ ){
                System.out.print(matriceNumeri[i][j] + "\t");
            }
            System.out.println();
        }
       
        }
       
        
    
    /**
    * 
    * Metodo per visualizzare i vincitori dell'estrazione
    */
    public void stampaVincitori() {
        // stampa array dei vincitori
        System.out.println("Numeri vincenti: ");
            for( int vincitore : vincitori){
                System.out.print(vincitore + "\t");
            }
            System.out.println();
        }

    /**
    * 
    * Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    */
    public void verifica(int numero, int idGiocatore) {
           boolean vinto = false;
           for(int i = 0; i< vincitori.length; i++){
               if(numero == vincitori[i]){
                   vinto = true;
                   break;
               }
           }
           
           if(vinto){
               System.out.println("Giocatore: " + idGiocatore + " ha vinto con il numero: " + numero); 
               
           } else{
               System.out.println("Giocatore: " + idGiocatore + " ha perso con il numero: " + numero);
           }
}
    /**
    * 
    * Metodo per eseguire il thread
    */
    
   
    
    public void run() {
        // stampa iniziale
        System.out.println("INIZIO ESTRAZIONE!");
        // estrazione dei numeri
        
        // stampa matrice
       
        // stampa finale
        
    }
}




