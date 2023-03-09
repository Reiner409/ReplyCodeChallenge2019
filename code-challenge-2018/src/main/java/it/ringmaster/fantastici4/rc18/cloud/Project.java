package it.ringmaster.fantastici4.rc18.cloud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Project {

    private int penalty;

    private String country;

    // Units per service
    private List<Integer> unitsNeeded;

    private List<Purchase> purchases;

    public int getTotalUnitPurchased() {
        int tot = 0;
        for (Purchase pur : purchases) {
            tot += pur.getNumPackages();
        }
        return tot;
    }

    public int getTotUnitsNeeded() {
        return unitsNeeded.stream().reduce(0, Integer::sum);
    }

    public List<Integer> getServiceUnits() {
        List<Integer> list = new ArrayList<>();
        return null;
    }
}
