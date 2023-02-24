package it.ringcodingchallenge.fantastici4.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class F4Reader {

    private String name;
    private BufferedReader fileReader;

    public F4Reader(String name) {
        this.name = name;
        this.fileReader = null;
    }

    public void open(){
        try {
            this.fileReader = new BufferedReader(new FileReader(this.name));
        } catch (IOException e) {
            System.out.println("F4Reader::open error - " + e);
        }
    }

    public void close(){
        try {
            this.fileReader.close();
        } catch (IOException e) {
            System.out.println("F4Reader::close error - " + e);
        }
    }

    public String readLine(){
        String line = null;

        try {
            line = this.fileReader.readLine();
        } catch (IOException e) {
            System.out.println("F4Reader::readLine error - " + e);
        }

        return line;
    }

    public String[] readLine(String separator){
        String[] line = null;

        try {
            line = this.fileReader.readLine().split(separator);
        } catch (IOException e) {
            System.out.println("F4Reader::readLine error - " + e);
        }

        return line;
    }

    /*
    public static void main(String[] args) {
        String line;

        F4Reader reader = new F4Reader("prova.txt");
        reader.open();

        while((line = reader.readLine()) != null){
            System.out.println(line);
        }

        reader.close();
    }
    */

}
