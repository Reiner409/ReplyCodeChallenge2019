package it.ringmaster.fantastici4.rc23;

import it.ringmaster.fantastici4.rc23.common.F4Reader;
import it.ringmaster.fantastici4.rc23.common.F4Writer;

public class Application {

    private static final String folder = "D:\\Repos\\Challenge\\ReplyCodeChallenge2019\\code-challenge-2023\\src\\main\\resources\\";
    private static final String inputFile1 = "";
    private static final String inputFile2 = "";
    private static final String inputFile3 = "";
    private static final String inputFile4 = "";

    public static void getInput(String fileName){

        F4Reader reader = new F4Reader(folder+fileName);
        reader.open();

        // Spacchettare i dati in ingresso nelle varie classi

        reader.close();
    }

    public static void printOutput(String fileName){
        F4Writer writer = new F4Writer(folder+fileName+"_output");
        writer.open();

        // Mettere i dati su una riga da far printare nel file

        writer.close();
    }

    public static void main(String[] args) {
        String fileName = inputFile1;
        getInput(fileName);

        // Logica quì!

        printOutput(fileName);
    }
}
