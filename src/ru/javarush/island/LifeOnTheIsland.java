package ru.javarush.island;

public class LifeOnTheIsland implements Runnable{
    private final IslandLocation[][] islandResidents;
    private int newCycle;
    public LifeOnTheIsland(IslandLocation[][] islandResidents){
        this.islandResidents=islandResidents;
    }
    @Override
    public void run() {
        for (int i = 0; i < islandResidents.length; i++) {
            for (int j = 0; j < islandResidents[i].length; j++) {
            deathFromExhaustion(islandResidents[i][j]);
            eatAnimal(islandResidents[i][j]);
            move(islandResidents[i][j],i,j);
            bornAnimal(islandResidents[i][j]);
            }
        }
        this.newCycle++;
    }
    public void move(IslandLocation islandLocation,int cellY,int cellX){
        islandLocation.move(cellY,cellX);
    }
    public void deathFromExhaustion(IslandLocation islandLocation){
        islandLocation.deathFromExhaustion();
    }
    public synchronized void eatAnimal(IslandLocation islandLocation){
        islandLocation.animalEat();
    }
    public void bornAnimal(IslandLocation islandLocation){
        islandLocation.bornAnimal();
    }
}
