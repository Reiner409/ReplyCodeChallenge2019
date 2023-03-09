package it.ringmaster.fantastici4.rc23;

import it.ringmaster.fantastici4.rc23.common.F4Reader;
import it.ringmaster.fantastici4.rc23.common.F4Writer;

public class Application {

    private static final String inputFile = "C:\\Users\\utente\\workspace\\code-challenge\\ReplyCodeChallenge2019\\src\\main\\resources\\input\\fourth_adventure.in";
    private static final String outputFile = "C:\\Users\\utente\\workspace\\code-challenge\\ReplyCodeChallenge2019\\src\\main\\resources\\output\\output4.txt";

    public static void getInput(){

        F4Reader reader = new F4Reader("C:\\Users\\utente\\workspace\\code-challenge\\ReplyCodeChallenge2019\\src\\main\\resources\\input\\fourth_adventure.in");
        reader.open();

        // Spacchettare i dati in ingresso nelle varie classi

        reader.close();
    }

    public static void printOutput(){
        F4Writer writer = new F4Writer(outputFile);
        writer.open();

        // Mettere i dati su una riga da far printare nel file

        writer.close();
    }

    public static void main(String[] args) {

        getInput();

        // Logica quì!

        printOutput();
    }
}
