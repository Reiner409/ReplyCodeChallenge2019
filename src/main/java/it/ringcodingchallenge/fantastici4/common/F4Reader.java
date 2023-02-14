package it.ringcodingchallenge.fantastici4.common;

import java.io.FileReader;
import java.io.IOException;

public class F4Reader {

    private String name;
    private FileReader fileReader;

    public F4Reader(String name) {
        this.name = name;
        this.fileReader = null;
    }

    public void open(){
        try {
            this.fileReader = new FileReader(this.name);
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


}
