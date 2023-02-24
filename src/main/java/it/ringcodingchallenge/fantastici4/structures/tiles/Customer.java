package it.ringcodingchallenge.fantastici4.structures.tiles;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class Customer extends Tile implements Comparable<Customer> {
    Double reward;

    public Customer(int x, int y, double reward) {
        super(x, y);
        this.reward = reward;
    }

    @Override
    public int compareTo(Customer customer) {
        return this.reward.intValue() - customer.reward.intValue();
    }
}
