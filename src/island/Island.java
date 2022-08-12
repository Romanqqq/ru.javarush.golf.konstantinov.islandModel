package island;

public class Island {
    static int side = 4;
    private static final IslandLocation[][] islandLocations = new IslandLocation[side][side];

    public Island() {
        for (int i = 0; i < islandLocations.length; i++) {
            for (int j = 0; j < islandLocations[i].length; j++) {
                islandLocations[i][j] = new IslandLocation();
            }

        }
    }


    public IslandLocation[][] getIslandLocation(){
        return islandLocations;
    }
    public static IslandLocation[][] getIslandLocationStatic(){
        return islandLocations;
    }


}
