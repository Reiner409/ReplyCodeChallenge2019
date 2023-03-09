package it.ringmaster.fantastici4.rc19.structures.tiles;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Reply extends Tile{

    private List<String> pathsToOffices;

    public Reply(int x, int y) {
        super(x, y);
        this.pathsToOffices = new ArrayList<>();
    }

    public void addPath(String path){
        this.pathsToOffices.add(path);
    }
}
