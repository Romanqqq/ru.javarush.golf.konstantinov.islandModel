package ru.javarush.island;

import ru.javarush.IslandSettings;

public class Island {
    private static final IslandLocation[][] islandLocations = new IslandLocation[IslandSettings.cellY][IslandSettings.cellX];

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
