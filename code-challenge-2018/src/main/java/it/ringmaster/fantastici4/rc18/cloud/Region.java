package it.ringmaster.fantastici4.rc18.cloud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Region {

    private String name;

    // Num packages
    private int availablePackages;

    // Package cost
    private float packageUnitCost;

    // Service units per package
    private List<Integer> units;

    // Latencies per country
    private List<Integer> latencies;

}
