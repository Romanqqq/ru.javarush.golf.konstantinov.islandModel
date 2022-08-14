package ru.javarush.island;

import ru.javarush.animal.Animal;
import ru.javarush.animal.Herbivorous;
import ru.javarush.animal.Raptor;
import ru.javarush.animal.herbivore.*;
import ru.javarush.animal.predator.*;
import ru.javarush.parameter.FillingTheIsland;
import ru.javarush.parameter.Info;
import ru.javarush.parameter.MovementOnTheIsland;
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
        int numberPlantsCell = ThreadLocalRandom.current().nextInt(1, Plant.getMaxQuantityLocation());
        for (int i = 1; i <= numberPlantsCell; i++) {
            cellPlants.add(new Plant());
        }
    }

    public void addPlants() {
        if (this.cellPlants.size() < Info.plantMaxQuantityLocation) {
            int difference = Info.plantMaxQuantityLocation - this.cellPlants.size();
            int addPlants = ThreadLocalRandom.current().nextInt(0, difference);
            for (int i = 0; i < addPlants; i++) {
                this.cellPlants.add(new Plant());
            }
        }
    }

    public void addAnAnimalToACell(Animal animal) {
        if (animal instanceof Raptor) {
            cellPredators.add(animal);
        } else if (animal instanceof Herbivorous) {
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

    public void saturationDecreases() {
        for (Animal predator : cellPredators) {
            if (predator.getHungryAnimalTime() <= 0) {
                cellPredators.remove(predator);
            } else {
                predator.hunger();
            }
        }
        for (Animal herbivore : cellHerbivore) {
            if (herbivore.getHungryAnimalTime() <= 0) {
                cellHerbivore.remove(herbivore);
            } else {
                herbivore.hunger();
            }
        }
    }

    public void move(int cellY, int cellX) {
        IslandLocation[][] islandLocations = Island.getIslandLocationStatic();
        movementOnTheIsland.movementOfAnimalsOnTheIsland(cellPredators, islandLocations, cellY, cellX);
        movementOnTheIsland.movementOfAnimalsOnTheIsland(cellHerbivore, islandLocations, cellY, cellX);
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

    public String numberOfLiveHerbivore() {
        int boar = cellHerbivore.stream().filter(animal -> animal instanceof Boar).toList().size();
        int buffalo = cellHerbivore.stream().filter(animal -> animal instanceof Buffalo).toList().size();
        int caterpillar = cellHerbivore.stream().filter(animal -> animal instanceof Caterpillar).toList().size();
        int deer = cellHerbivore.stream().filter(animal -> animal instanceof Deer).toList().size();
        int duck = cellHerbivore.stream().filter(animal -> animal instanceof Duck).toList().size();
        int goat = cellHerbivore.stream().filter(animal -> animal instanceof Goat).toList().size();
        int horse = cellHerbivore.stream().filter(animal -> animal instanceof Horse).toList().size();
        int mouse = cellHerbivore.stream().filter(animal -> animal instanceof Mouse).toList().size();
        int rabbit = cellHerbivore.stream().filter(animal -> animal instanceof Rabbit).toList().size();
        int sheep = cellHerbivore.stream().filter(animal -> animal instanceof Sheep).toList().size();
        StringBuilder statisticHerbivore = new StringBuilder();
        statisticHerbivore.append("  \uD83D\uDC17 : ").append(boar).append("  \uD83D\uDC2E : ").append(buffalo)
                .append("  \uD83D\uDC1B : ").append(caterpillar).append("  \uD83E\uDD8C : ").append(deer)
                .append("  \uD83E\uDD86 : ").append(duck).append("  \uD83D\uDC10 : ").append(goat)
                .append("  \uD83D\uDC0E : ").append(horse).append("  \uD83D\uDC01 : ").append(mouse)
                .append("  \uD83D\uDC07 : ").append(rabbit).append("  \uD83D\uDC11 : ").append(sheep);
        return String.valueOf(statisticHerbivore);
    }

    public String numberOfLivePredator() {
        int bear = cellPredators.stream().filter(animal -> animal instanceof Bear).toList().size();
        int boa = cellPredators.stream().filter(animal -> animal instanceof Boa).toList().size();
        int eagle = cellPredators.stream().filter(animal -> animal instanceof Eagle).toList().size();
        int fox = cellPredators.stream().filter(animal -> animal instanceof Fox).toList().size();
        int wolf = cellPredators.stream().filter(animal -> animal instanceof Wolf).toList().size();
        StringBuilder statisticPredator = new StringBuilder();
        statisticPredator.append("  \uD83D\uDC3B : ").append(bear).append("  \uD83D\uDC0D : ").append(boa)
                .append("  \uD83E\uDD85 : ").append(eagle).append("  \uD83E\uDD8A : ").append(fox)
                .append("  \uD83D\uDC3A : ").append(wolf);
        return String.valueOf(statisticPredator);
    }
}