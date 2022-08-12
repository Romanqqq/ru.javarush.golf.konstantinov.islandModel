package parameter;

import island.IslandLocation;

public class StatisticIsland implements Runnable {
    private int iteration;
    private final IslandLocation[][] islandLocations;

    public StatisticIsland(IslandLocation[][] islandLocations) {
        this.islandLocations = islandLocations;
    }

    @Override
    public void run() {
        System.out.println("День " + iteration);
        growPlants(islandLocations);
        printIslandStatistics(islandLocations);
        this.iteration++;
    }

    public static void printIslandStatistics(IslandLocation[][] islandLocations) {
        try {
            for (int i = 0; i < islandLocations.length; i++) {
                for (int j = 0; j < islandLocations[i].length; j++) {
                    System.out.println("Ячейка: " + i + " " + j);
                    System.out.println("Растений: " + islandLocations[i][j].getCellPlants());
                    System.out.println("Травоядных: " + islandLocations[i][j].getCellHerbivore());
                    System.out.println("Хищников: " + islandLocations[i][j].getCellPredators());

                }
            }
            System.out.println("**************************************************************************");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void growPlants(IslandLocation[][] islandLocations) {
        try {
            for (int i = 0; i < islandLocations.length; i++) {
                for (int j = 0; j < islandLocations[i].length; j++) {
                    islandLocations[i][j].addPlants();

                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
