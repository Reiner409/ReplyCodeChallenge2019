package it.ringcodingchallenge.fantastici4.structures.tiles;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TerrainType {
    RAILWAY('T', 50d),
    HIGHWAY('H', 70d),
    STANDARD_TERRAIN('_', 100d),
    RAILWAY_LEVEL_CROSSING('X', 120d),
    DIRT('+', 150d),
    TRAFFIC_JAM('*', 200d),
    WATER('~', 800d),
    MOUNTAINS('#', Double.POSITIVE_INFINITY);

    char symbol;
    double cost;
    TerrainType(char symbol, double cost)
    {
        this.symbol = symbol;
        this.cost = cost;
    }

//    public void setCost(double cost)
//    {
//        this.cost = cost;
//    }
}
