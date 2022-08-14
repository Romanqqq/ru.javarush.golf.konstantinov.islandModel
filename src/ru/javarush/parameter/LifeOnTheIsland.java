package ru.javarush.parameter;

import ru.javarush.island.IslandLocation;

public class LifeOnTheIsland implements Runnable{
    private final IslandLocation[][] islandObject;
    private int newCycle;
    public LifeOnTheIsland(IslandLocation[][] islandObject){
        this.islandObject =islandObject;
    }
    @Override
    public void run() {
        for (int i = 0; i < islandObject.length; i++) {
            for (int j = 0; j < islandObject[i].length; j++) {
            saturationDecreases(islandObject[i][j]);
            eatAnimal(islandObject[i][j]);
            move(islandObject[i][j],i,j);
            bornAnimal(islandObject[i][j]);
            }
        }
        this.newCycle++;
    }
    public void move(IslandLocation islandLocation,int cellY,int cellX){
        islandLocation.move(cellY,cellX);
    }
    public void saturationDecreases(IslandLocation islandLocation){
        islandLocation.saturationDecreases();
    }
    public synchronized void eatAnimal(IslandLocation islandLocation){
        islandLocation.animalEat();
    }
    public void bornAnimal(IslandLocation islandLocation){
        islandLocation.bornAnimal();
    }
}
