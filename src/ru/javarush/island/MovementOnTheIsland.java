package ru.javarush.island;

import ru.javarush.animal.Animal;
import ru.javarush.animal.Herbivore;
import ru.javarush.animal.Predator;
import ru.javarush.parameter.Direction;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MovementOnTheIsland {

    public void movementOfAnimalsOnTheIsland(List<Animal> animal, IslandLocation[][] islandLocations, int cellX, int cellY) {
        int CELL_MAX_Y = islandLocations.length - 1;
        int CELL_MAX_X = islandLocations[CELL_MAX_Y].length - 1;
        int MIN_Y = 0;
        int MIN_X = 0;
        for (Animal animal1 : animal) {
            int chanceToWalk = ThreadLocalRandom.current().nextInt(0, 100);
            if (chanceToWalk > 60) {
                int numberOfStep = ThreadLocalRandom.current().nextInt(animal1.getMovementSpeed());
                int countAnimalMax = 0;
                Field maxQuantityTypeAnimalCell;
                try {
                    maxQuantityTypeAnimalCell = animal1.getClass().getDeclaredField("maxQuantityTypeAnimal");
                    maxQuantityTypeAnimalCell.setAccessible(true);
                    countAnimalMax = (int) maxQuantityTypeAnimalCell.get(null);
                } catch (Exception x) {
                    x.printStackTrace();
                }
                Direction directionOfMovement = animal1.directionOfMovement();
                try {
                    if (directionOfMovement.equals(Direction.UP)) {
                        if ((cellY - numberOfStep) >= MIN_Y) {
                            if (checkingTheMaximumNumberOfAnimalSpecies(animal1, islandLocations, countAnimalMax, cellX,
                                    cellY - numberOfStep)) {
                                islandLocations[cellY - numberOfStep][cellX].addAnAnimalToACell(animal1);
                                animal.remove(animal1);
                            }
                        }
                    } else if (directionOfMovement.equals(Direction.RIGHT)) {
                        if ((cellY - numberOfStep) >= CELL_MAX_X) {
                            if (checkingTheMaximumNumberOfAnimalSpecies(animal1, islandLocations, countAnimalMax,
                                    cellX + numberOfStep, cellY)) {
                                islandLocations[cellY][cellX + numberOfStep].addAnAnimalToACell(animal1);
                                animal.remove(animal1);
                            }
                        }
                    } else if (directionOfMovement.equals(Direction.DOWN)) {
                        if ((cellY - numberOfStep) >= CELL_MAX_Y) {
                            if (checkingTheMaximumNumberOfAnimalSpecies(animal1, islandLocations, countAnimalMax, cellX,
                                    cellY + numberOfStep)) {
                                islandLocations[cellY + numberOfStep][cellX].addAnAnimalToACell(animal1);
                                animal.remove(animal1);
                            }
                        }
                    } else if (directionOfMovement.equals(Direction.LEFT)) {
                        if ((cellY - numberOfStep) >= MIN_X) {
                            if (checkingTheMaximumNumberOfAnimalSpecies(animal1, islandLocations, countAnimalMax, cellX - numberOfStep, cellY)) {
                                islandLocations[cellY][cellX - numberOfStep].addAnAnimalToACell(animal1);
                                animal.remove(animal1);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private boolean checkingTheMaximumNumberOfAnimalSpecies(Animal animal, IslandLocation[][] islandLocations, int maxQuantityTypeAnimal, int cellX, int cellY) {
        boolean addNewAnimal = false;
        int animalInTheCell = 0;
        if (animal instanceof Predator) {
            animalInTheCell =(int) islandLocations[cellX][cellY].getCellPredators();
        } else if (animal instanceof Herbivore) {
            animalInTheCell = (int)islandLocations[cellX][cellY].getCellHerbivore();
        }
        if ((animalInTheCell + 1) <= maxQuantityTypeAnimal) {
            addNewAnimal = true;
        }
        return addNewAnimal;
    }
}
