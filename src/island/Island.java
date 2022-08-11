package island;

public class Island {
    static int side = 2;
    static IslandLocation[][] islandLocations = new IslandLocation[side][side];

    public void initialize() {
        for (int i = 0; i < islandLocations.length; i++) {
            for (int j = 0; j < islandLocations[i].length; j++) {
                islandLocations[i][j] = new IslandLocation();
            }

        }
    }

    public void printIslandStatistics() {
        for (int i = 0; i < islandLocations.length; i++) {
            for (int j = 0; j < islandLocations[i].length; j++) {
                System.out.println(islandLocations[i][j].getClass().getSimpleName());
                System.out.println("Ячейка: " + i + " " + j);
                System.out.println("Растений: " + islandLocations[i][j].plantsGrow());
                System.out.println("Травоядных: " + islandLocations[i][j].herbivoresInitialize());
                System.out.println("Хищников: " + islandLocations[i][j].predatorInitialize());

            }
        }
    }
    public static IslandLocation[][] getIslandLocation(){
        return islandLocations;
    }


}
