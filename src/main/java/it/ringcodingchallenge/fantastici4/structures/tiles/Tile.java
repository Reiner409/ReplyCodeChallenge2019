package it.ringcodingchallenge.fantastici4.structures.tiles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Tile {
    final int x;
    final int  y;

    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
