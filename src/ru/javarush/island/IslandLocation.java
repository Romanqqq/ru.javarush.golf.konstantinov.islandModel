package ru.javarush.island;

import ru.javarush.animal.Animal;
import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Predator;
import ru.javarush.parameter.ScannerAnimal;
import ru.javarush.plant.Plant;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class IslandLocation {
    FillingTheIsland fillingTheIsland = new FillingTheIsland();
    MovementOnTheIsland movementOnTheIsland = new MovementOnTheIsland();
    Set<Class> predatorAnimal = ScannerAnimal.getPredatorAnimal();
    Set<Class> herbivoreAnimal = ScannerAnimal.getHerbivoreAnimal();

    private final List<Plant> cellPlants = new CopyOnWriteArrayList<>();
    private final List<Animal> cellPredators = fillingTheIsland.fillingIsland(predatorAnimal);
    private final List<Animal> cellHerbivore = fillingTheIsland.fillingIsland(herbivoreAnimal);


    public IslandLocation() {
        plantsGrow();
    }

    private void plantsGrow() {
        int numberPlantsCell = ThreadLocalRandom.current().nextInt(1, Plant.getMaxQuantity());
        for (int i = 1; i <= numberPlantsCell; i++) {
            cellPlants.add(new Plant());
        }
    }

    public void addPlants() {
        if (this.cellPlants.size() < Plant.getMaxQuantity()) {
            int difference = Plant.getMaxQuantity() - this.cellPlants.size();
            int addPl = ThreadLocalRandom.current().nextInt(0, difference);
            for (int i = 0; i < addPl; i++) {
                this.cellPlants.add(new Plant());
            }
        }
    }

    public void addAnAnimalToACell(Animal animal) {
        if (animal instanceof Predator) {
            cellPredators.add(animal);
        } else if (animal instanceof Herbivore) {
            cellHerbivore.add(animal);
        }
    }

    public void bornAnimal() {
        fillingTheIsland.reproductionAnimal(predatorAnimal, cellPredators);
        fillingTheIsland.reproductionAnimal(herbivoreAnimal, cellHerbivore);
    }

    public void animalEat() {
        try {
            for (Animal predator : cellPredators) {
                predator.eat(cellHerbivore, cellPredators);
            }
            for (Animal herbivore : cellHerbivore) {
                herbivore.eat(cellPlants, cellHerbivore);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deathFromExhaustion() {
        for (Animal herbivore : cellHerbivore) {
            if (herbivore.getHungryAnimalTime() <= 0) {
                cellHerbivore.remove(herbivore);
            } else {
                herbivore.hunger();
            }
        }
        for (Animal predator : cellPredators) {
            if (predator.getHungryAnimalTime() <= 0) {
                cellPredators.remove(predator);
            } else {
                predator.hunger();
            }
        }
    }

    public void move(int cellY, int cellX) {
        IslandLocation[][] islandLocations = Island.getIslandLocationStatic();
        movementOnTheIsland.movementOfAnimalsOnTheIsland(cellPredators, islandLocations, cellX, cellY);
        movementOnTheIsland.movementOfAnimalsOnTheIsland(cellHerbivore, islandLocations, cellX, cellY);
    }

    public long getCellPlants() {
        return cellPlants.size();
    }

    public long getCellPredators() {
        return cellPredators.size();
    }

    public long getCellHerbivore() {
        return cellHerbivore.size();
    }
}