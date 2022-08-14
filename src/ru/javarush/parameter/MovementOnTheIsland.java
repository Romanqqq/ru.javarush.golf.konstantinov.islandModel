package ru.javarush.parameter;

import ru.javarush.animal.Animal;
import ru.javarush.animal.Herbivorous;
import ru.javarush.animal.Raptor;
import ru.javarush.island.IslandLocation;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MovementOnTheIsland {
    public MovementOnTheIsland(){}

    public void movementOfAnimalsOnTheIsland(List<Animal> animalList, IslandLocation[][] islandLocations, int cellY, int cellX) {
        int MIN_Y = 0;
        int MIN_X = 0;
        int CELL_MAX_Y = islandLocations.length - 1;
        int CELL_MAX_X = islandLocations[CELL_MAX_Y].length - 1;

        for (Animal animal : animalList) {
            int chanceToWalk = ThreadLocalRandom.current().nextInt(0, 100);

            if (chanceToWalk > 80) {

                int numberOfStep = ThreadLocalRandom.current().nextInt(0,animal.getMovementSpeed());

                Field maxQuantityLocationCell;
                int countAnimalMax;
                try {
                    maxQuantityLocationCell = animal.getClass().getDeclaredField("maxQuantityLocation");
                    maxQuantityLocationCell.setAccessible(true);
                    countAnimalMax = (int) maxQuantityLocationCell.get(null);
                } catch (NoSuchFieldException | IllegalAccessException x) {
                    throw new RuntimeException(x);
                }

                Direction directionOfMovement = animal.setDirectionOfMovement();
                try {
                    if (directionOfMovement.equals(Direction.UP)) {
                        if ((cellY - numberOfStep) >= MIN_Y) {
                            if (checkingTheMaximumNumberOfAnimalSpecies(animal, islandLocations, countAnimalMax, cellY - numberOfStep,cellX)) {
                                islandLocations[cellY - numberOfStep][cellX].addAnAnimalToACell(animal);
                                animalList.remove(animal);
                            }
                        }
                    } else if (directionOfMovement.equals(Direction.RIGHT)) {
                        if ((cellX + numberOfStep) <= CELL_MAX_X) {
                            if (checkingTheMaximumNumberOfAnimalSpecies(animal, islandLocations, countAnimalMax, cellY,cellX + numberOfStep)) {
                                islandLocations[cellY][cellX + numberOfStep].addAnAnimalToACell(animal);
                                animalList.remove(animal);
                            }
                        }
                    } else if (directionOfMovement.equals(Direction.DOWN)) {
                        if ((cellY + numberOfStep) <= CELL_MAX_Y) {
                            if (checkingTheMaximumNumberOfAnimalSpecies(animal, islandLocations, countAnimalMax, cellY + numberOfStep,cellX)) {
                                islandLocations[cellY + numberOfStep][cellX].addAnAnimalToACell(animal);
                                animalList.remove(animal);
                            }
                        }
                    } else if (directionOfMovement.equals(Direction.LEFT)) {
                        if ((cellX - numberOfStep) >= MIN_X) {
                            if (checkingTheMaximumNumberOfAnimalSpecies(animal, islandLocations, countAnimalMax,  cellY, cellX - numberOfStep)) {
                                islandLocations[cellY][cellX - numberOfStep].addAnAnimalToACell(animal);
                                animalList.remove(animal);
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private boolean checkingTheMaximumNumberOfAnimalSpecies(Animal animal, IslandLocation[][] islandLocations, int maxQuantityLocation, int cellY,int cellX ) {
        boolean addNewAnimal = false;
        int animalInTheCell = 0;
        if (animal instanceof Raptor) {
            animalInTheCell =(int) islandLocations[cellY][cellX].getCellPredators();
        } else if (animal instanceof Herbivorous) {
            animalInTheCell = (int)islandLocations[cellY][cellX].getCellHerbivore();
        }
        if ((animalInTheCell + 1) <= maxQuantityLocation) {
            addNewAnimal = true;
        }
        return addNewAnimal;
    }
}
