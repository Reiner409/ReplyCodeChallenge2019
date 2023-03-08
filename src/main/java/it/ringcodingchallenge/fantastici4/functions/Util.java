package it.ringcodingchallenge.fantastici4.functions;

import it.ringcodingchallenge.fantastici4.structures.cloud.Project;
import it.ringcodingchallenge.fantastici4.structures.cloud.Purchase;
import it.ringcodingchallenge.fantastici4.structures.cloud.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static double overallQualityScore(List<Integer> latencies, List<Purchase> purchases) {
        double avgProjectLatency = averageProjectLatency(latencies, purchases);
        double overallAvailabilityIdx = overallAvailabilityIndex(null); // TODO
        double opProjectCost = totalOperationalProjectCost(null); // TODO

        return (avgProjectLatency / overallAvailabilityIdx) * opProjectCost;
    }

    public static double averageProjectLatency(List<Integer> latencies, List<Purchase> purchases) {
        int totalUnits = 0;
        for (Purchase p : purchases) {
            totalUnits += p.getNumPackages();
        }
        if (totalUnits == 0)
            return 0;

        int numRegions = latencies.size();
        double latencyPerUnits = 0;

        for (int i=0; i < numRegions; i++) {
            latencyPerUnits += latencies.get(i) * purchases.get(i).getNumPackages();
        }

        return latencyPerUnits / totalUnits;
    }

    public static int computationalUnitsBought(int packages, int serviceUnits) {
        return packages * serviceUnits;
    }

    public static double overallAvailabilityIndex(List<Purchase> purchases) {
        List<Double> availabilityIndexes = new ArrayList<>();
        purchases.forEach(purchase -> serviceAvailabilityIndex(null)); // TODO

        double totAvailab = availabilityIndexes.stream().reduce(0d, Double::sum);
        int numOfservices = availabilityIndexes.size();

        return totAvailab / numOfservices;
    }

    public static double serviceAvailabilityIndex(List<Integer> serviceUnits) {
        double availabilityIndex = 0;
        int num =0;
        int den = 0;

        for (int i=0; i< serviceUnits.size(); i++) {
            num += serviceUnits.get(i);
            den += Math.pow(serviceUnits.get(i), 2);
        }

        availabilityIndex = Math.pow(num, 2) / den;
        return availabilityIndex;
    }

    public static int totalOperationalProjectCost(List<Integer> list) {
        // TODO
        return list.stream().reduce(0, Integer::sum);
    }

    public static int operationalProjectCost(int penalty, int numPackages) {
        return penalty * numPackages;
    }

    public static double calculateFine(int penalty, int unitsNeeded, int unitsAllocated) {
        return penalty * (1 - Math.min(unitsNeeded, unitsAllocated) / (double)unitsNeeded);
    }

    public static double avgOfFines(List<Double> fines) {
        double totFine = fines.stream().reduce(0d, Double::sum);
        int numOfservices = fines.size();

        return totFine / numOfservices;
    }

    public static double projectScore(Project p, Region r, int countryIdx) {
        // TODO
        int overallQualityScore =0;
//        overallQualityScore = overallQualityScore(
//                r.getLatencies(), p.getPurchases()
//                );
        double slaPenalty = calculateFine(p.getPenalty(), p.getTotUnitsNeeded(), p.getTotalUnitPurchased());

        return Math.pow(10,9) / (overallQualityScore + slaPenalty);
    }

}
