package Palindromo;

import Queue.*;
import Stack.PilaD;
import Stack.PilaE;

/**
 * Created by Paca on 4/11/14.
 */
public class Palindromo {
    QueueE quequeE = new QueueE();
    PilaE pilaE = new PilaE();

    QueueD quequeD = new QueueD();
    PilaD pilaD = new PilaD();

    public boolean dinamicPalindromo(String wordToAnalize){

        for (int i = 0; i < wordToAnalize.length() ; i++) {
            quequeD.enqueue(wordToAnalize.charAt(i));
            pilaD.apilar(wordToAnalize.charAt(i));
        }


        for (int i = 0; i < wordToAnalize.length() / 2 ; i++) {
            if (quequeD.getFirst() != pilaD.verTope()){
                return false;
            }

            quequeD.dequeue();
            pilaD.desapilar();
        }
        return true;

    }

    public boolean estaticPalindromo(String wordToAnalize){
        for (int i = 0; i < wordToAnalize.length() ; i++) {
            quequeE.enqueue(wordToAnalize.charAt(i));
            pilaE.apilar(wordToAnalize.charAt(i));
        }


        for (int i = 0; i < wordToAnalize.length() / 2 ; i++) {
            if (quequeE.getFirst() != pilaE.verTope()){
                return false;
            }

            quequeE.dequeue();
            pilaE.desapilar();
        }
    return true;
    }

}
