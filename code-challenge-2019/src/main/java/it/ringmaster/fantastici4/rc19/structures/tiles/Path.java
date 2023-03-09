package it.ringmaster.fantastici4.rc19.structures.tiles;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Path {
    private List<Tile> tiles;
    private double cost;
}
