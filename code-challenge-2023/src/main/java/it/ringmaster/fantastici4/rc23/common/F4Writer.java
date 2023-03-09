package it.ringmaster.fantastici4.rc23.common;

import java.io.FileWriter;
import java.io.IOException;

public class F4Writer {

    private String name;
    private FileWriter fileWriter;

    public F4Writer(String name) {
        this.name = name;
        this.fileWriter = null;
    }

    public void open(){
        try {
            this.fileWriter = new FileWriter(this.name);
        } catch (IOException e) {
            System.out.println("F4Writer::open error - " + e);
        }
    }

    public void close(){
        try {
            this.fileWriter.close();
        } catch (IOException e) {
            System.out.println("F4Writer::close error - " + e);
        }
    }

    public void writeLine(String line){

        if(this.fileWriter != null){
            try {
                this.fileWriter.write(line + "\n");
            } catch (IOException e) {
                System.out.println("F4Writer::writeLine error - " + e);
            }
        }

    }

    public void writeLine(String separator, Object ... fields){

        if(fields.length < 1){
            return;
        }

        StringBuilder line = new StringBuilder();

        for(int i=0; i<fields.length -1; i++){
            line.append(fields[i].toString()).append(separator);
        }

        line.append(fields[fields.length - 1].toString());

        this.writeLine(String.valueOf(line));
    }

    /*
    public static void main(String[] args) {

        F4Writer writer = new F4Writer("prova.txt");
        writer.open();

        writer.writeLine(",", "inizio", 10, 10.90, "fine");
        writer.writeLine(" ", "inizio", 10, 10.90, 50, 60, -1, "fine");

        writer.close();
    }
    */

}
