package it.ringcodingchallenge.fantastici4.structures;

import it.ringcodingchallenge.fantastici4.structures.tiles.Customer;
import it.ringcodingchallenge.fantastici4.structures.tiles.Terrain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PathClass {
    public Terrain choosePath(Terrain actual, Terrain up, Terrain right, Terrain down, Terrain left, Customer customer) {
        Map<Integer, Terrain> tiles = new HashMap<>();
        tiles.put(0, up);
        tiles.put(1, right);
        tiles.put(2, down);
        tiles.put(3, left);

        double totalCost = 0;
        Double nearestCost = Double.POSITIVE_INFINITY;
        Integer near=0;

        for (int i = 0; i <= 3; i++) {
            Terrain t = tiles.get(i);
            if (t != null) {
                Double distanza = this.getDistanza(t, customer);
                if (t.getTerrainType().getCost() != Double.POSITIVE_INFINITY) {
                    totalCost += t.getTerrainType().getCost();
                    if (distanza < nearestCost) {
                        nearestCost = distanza;
                        near = i;
                    }
                }
            }
        }

        Terrain nearest = tiles.get(near);
        Double newNearestValue = nearest.getTerrainType().getCost() * 0.8;
        totalCost = totalCost - nearestCost + newNearestValue;
        Map<Integer, Double> individualCosts = new HashMap<>();
        for (int i = 0; i <= 3; i++) {
            if (i==near)
                individualCosts.put(i,(totalCost - newNearestValue)/totalCost);
            else
                individualCosts.put(i, (totalCost - tiles.get(i).getTerrainType().getCost())/totalCost);
        }

        for (int i = 0; i <= 3; i++) {

        }

        Random rand = new Random();

        return null;
    }

    private Double getDistanza(Terrain t, Customer c)
    {
        return Math.pow(
                Math.pow(t.getX()+c.getX(),2)+
                        Math.pow(t.getY()+c.getY(),2)
                ,1/2);
    }
}
