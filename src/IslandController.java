import island.Island;
import island.IslandLocation;

public class IslandController {




    public static void main(String[] args) {
        //создали объект остров
        Island island = new Island();
        IslandLocation islandLocation = new IslandLocation();
        islandLocation.initialize();
        island.plantsGrow();
        island.predatorInitialize();
        island.herbivoresInitialize();
        islandLocation.printIslandStatistics();
            }





}