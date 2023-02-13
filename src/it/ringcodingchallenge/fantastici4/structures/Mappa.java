package it.ringcodingchallenge.fantastici4.structures;

import it.ringcodingchallenge.fantastici4.structures.tiles.Terrain;
import it.ringcodingchallenge.fantastici4.structures.tiles.TerrainController;
import it.ringcodingchallenge.fantastici4.structures.tiles.Tile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mappa {
    int width;
    int height;
    int customerOffices;
    int replyOffices;
    Terrain[][] terrainMap;

    public Mappa(int width, int height, int customerOffices, int replyOffices)
    {
        this.width = width;
        this.height = height;
        this.customerOffices = customerOffices;
        this.replyOffices = replyOffices;
        this.terrainMap = new Terrain[width][height];
    }

    public void addTerrain(char c, int x, int y)
    {
        try {
            Terrain t = TerrainController.generateTerrain(c, x, y);
            terrainMap[x][y] = t;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                sb.append(terrainMap[x][y].getTerrainType().getSymbol());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public double getTerrainCost(int x, int y)
    {
        return this.terrainMap[x][y].getTerrainType().getCost();
    }
}
