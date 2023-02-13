package it.ringcodingchallenge.fantastici4.structures.tiles;

import static java.lang.System.exit;

public class TerrainController {

    public static Terrain generateTerrain(Character symbol, int x, int y) throws Exception {
        if (symbol.equals('T'))
            return new Terrain(TerrainType.RAILWAY, x, y);
        else if (symbol.equals('H'))
            return new Terrain(TerrainType.HIGHWAY, x, y);
        else if (symbol.equals('_'))
            return new Terrain(TerrainType.STANDARD_TERRAIN, x, y);
        else if (symbol.equals('X'))
            return new Terrain(TerrainType.RAILWAY_LEVEL_CROSSING, x, y);
        else if (symbol.equals('+'))
            return new Terrain(TerrainType.DIRT, x, y);
        else if (symbol.equals('*'))
            return new Terrain(TerrainType.TRAFFIC_JAM, x, y);
        else if (symbol.equals('~'))
            return new Terrain(TerrainType.WATER, x, y);
        else if (symbol.equals('#'))
            return new Terrain(TerrainType.MOUNTAINS, x, y);
        System.out.println("CARATTERE IN INPUT PASSATO ERRATO");
        throw new Exception("Carattere inviato non esistente");
    }
}
