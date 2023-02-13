package it.ringcodingchallenge.fantastici4.structures.tiles;

import lombok.Getter;

@Getter
public class Terrain extends Tile {
    private final TerrainType terrainType;

    public Terrain(TerrainType terrainType, int x, int y)
    {
        super(x,y);
        this.terrainType = terrainType;
    }

}
