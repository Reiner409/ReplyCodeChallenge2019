package it.ringmaster.fantastici4.rc18;


import it.ringmaster.fantastici4.rc18.common.F4Reader;
import it.ringmaster.fantastici4.rc18.common.F4Writer;
import it.ringmaster.fantastici4.rc18.cloud.Project;
import it.ringmaster.fantastici4.rc18.cloud.Provider;
import it.ringmaster.fantastici4.rc18.cloud.Purchase;
import it.ringmaster.fantastici4.rc18.cloud.Region;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void getInput(List<Provider> providers, List<String> services, List<String> countries, List<Project> projects){

        int numProviders, numServices, numCountries, numProjects, numRegions, i, j, k;

        String line;
        String values[];

        F4Reader reader = new F4Reader("C:\\Users\\utente\\workspace\\code-challenge\\ReplyCodeChallenge2019\\src\\main\\resources\\input\\fourth_adventure.in");
        reader.open();

        // First line
        values = reader.readLine(" ");
        numProviders = Integer.parseInt(values[0]);
        numServices = Integer.parseInt(values[1]);
        numCountries = Integer.parseInt(values[2]);
        numProjects = Integer.parseInt(values[3]);

        // Services
        values = reader.readLine(" ");
        for(i=0; i<numServices; i++){
            services.add(values[i]);
        }

        // Countries
        values = reader.readLine(" ");
        for(i=0; i<numCountries; i++){
            countries.add(values[i]);
        }

        // Providers
        for(i=0; i<numProviders; i++){
            Provider provider = new Provider();

            values = reader.readLine(" ");
            provider.setName(values[0]);
            numRegions = Integer.parseInt(values[1]);

            List<Region> regions = new ArrayList<>();

            for(j=0; j < numRegions; j++){
                Region region = new Region();

                region.setName(reader.readLine());

                values = reader.readLine(" ");

                region.setAvailablePackages(Integer.parseInt(values[0]));
                region.setPackageUnitCost(Float.parseFloat(values[1]));

                List<Integer> units = new ArrayList<>();
                for(k=0; k<numServices; k++){
                    units.add(Integer.parseInt(values[2+k]));
                }

                region.setUnits(units);

                values = reader.readLine(" ");

                List<Integer> latencies = new ArrayList<>();
                for(k=0; k<numCountries; k++){
                    latencies.add(Integer.parseInt(values[k]));
                }

                region.setLatencies(latencies);

                regions.add(region);
            }

            provider.setRegions(regions);

            providers.add(provider);
        }

        // Projects
        for(i=0; i<numProjects; i++){
            values = reader.readLine(" ");

            Project project = new Project();
            project.setPenalty(Integer.parseInt(values[0]));
            project.setCountry(values[1]);

            List<Integer> serviceUnits = new ArrayList<>();

            for(j=0; j<numServices; j++){
                serviceUnits.add(Integer.parseInt(values[2+j]));
            }

            project.setUnitsNeeded(serviceUnits);
            project.setPurchases(new ArrayList<>());

            projects.add(project);
        }

        reader.close();
    }

    public static void printOutput(List<Project> projects){
        StringBuilder line;

        F4Writer writer = new F4Writer("C:\\Users\\utente\\workspace\\code-challenge\\ReplyCodeChallenge2019\\src\\main\\resources\\output\\output4.txt");
        writer.open();

        for(Project project : projects){
            line = new StringBuilder();

            for(Purchase purchase : project.getPurchases()){
                line.append(purchase.getProvider()).append(" ").append(purchase.getRegion()).append(" ").append(purchase.getNumPackages()).append(" ");
            }

            writer.writeLine(line.toString());

        }

        writer.close();
    }

    public static int removeBoughtPackages(Project project, List<Provider> providers, int numProvider, int numRegion){
        int i;
        int numRemaining = 0;
        int unitsBought = 0;

        Provider provider = providers.get(numProvider);
        Region region = provider.getRegions().get(numRegion);
        List<Integer> units = project.getUnitsNeeded();

        // Total number of units needed
        for(i=0; i<units.size(); i++){
            numRemaining += units.get(i);
        }

        while(numRemaining > 0 && region.getAvailablePackages() > 0){

            for(i=0; i<units.size(); i++){
                units.set(i, units.get(i) - region.getUnits().get(i));
                numRemaining -= region.getUnits().get(i);
            }

            unitsBought ++;
            region.setAvailablePackages(region.getAvailablePackages() - 1);
        }

        project.setUnitsNeeded(units);

        return unitsBought;
    }

    public static void purchasePackages(Project project, List<Provider> providers, List<String> countries){
        int country, i, j;
        int bestProvider = -1;
        int bestRegion = -1;

        // Find country
        for(i=0; i<countries.size(); i++){
            if(countries.get(i).compareTo(project.getCountry()) == 0){
                country = i;
                break;
            }
        }

        for(i=0; i<providers.size(); i++){
            Provider provider = providers.get(i);

            for(j=0; j<provider.getRegions().size(); j++){
                Region region = provider.getRegions().get(j);

                bestProvider = i;
                bestRegion = j;

            }

        }

        int bought = removeBoughtPackages(project, providers, bestProvider, bestRegion);

        if(bought > 0){
            project.getPurchases().add(new Purchase(bestProvider, bestRegion, bought));
        }

    }


    public static void main(String[] args) {

        List<Provider> providers = new ArrayList<>();
        List<String> services = new ArrayList<>();
        List<String> countries = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        getInput(providers, services, countries, projects);

        for(int i=0; i<projects.size(); i++){
            purchasePackages(projects.get(i), providers, countries);
        }

        printOutput(projects);
    }


}
