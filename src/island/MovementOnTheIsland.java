package island;

import animal.Animal;
import animal.herbivore.Herbivore;
import animal.predator.Predator;
import parameter.Direction;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MovementOnTheIsland {
    //проверка на Максимальное количество животных одного вида в ячейке
    public boolean checkingTheMaximumNumberOfAnimalSpecies(Animal animal, IslandLocation[][] islandLocations, int maxQuantityTypeAnimal, int cellX, int cellY) {
        boolean addNewAnimal = false;
        int animalInTheCell = 0;
        if (animal instanceof Predator) {
            animalInTheCell = islandLocations[cellX][cellY].cellPredators.size();
        } else if (animal instanceof Herbivore) {
            animalInTheCell = islandLocations[cellX][cellY].cellHerbivore.size();
        }
        if ((animalInTheCell + 1) <= maxQuantityTypeAnimal) {
            addNewAnimal = true;
        }
        return addNewAnimal;
    }

    public void movementOfAnimalsOnTheIsland(List<Animal> animal, IslandLocation[][] islandLocations, int cellX, int cellY) {
        int CELL_MAX_Y = islandLocations.length - 1;
        int CELL_MAX_X = islandLocations[CELL_MAX_Y].length - 1;
        int MIN_Y = 0;
        int MIN_X = 0;
        for (Animal animal1 : animal) {
            int chanceToWalk = ThreadLocalRandom.current().nextInt(0, 100);
            if (chanceToWalk > 60) {
                int numberOfStep = animal1.getMovementSpeed();
                int countAnimalMax = 0;
                try {
                    Field maxQuantityTypeAnimalCell = animal1.getClass().getDeclaredField("maxQuantityTypeAnimal");
                    maxQuantityTypeAnimalCell.setAccessible(true);
                    countAnimalMax = (int) maxQuantityTypeAnimalCell.get(null);
                } catch (Exception x) {
                    x.printStackTrace();
                }
                Direction directionOfMovement = animal1.directionOfMovement();

                if (directionOfMovement.equals(Direction.UP)) {
                    if ((cellY - numberOfStep) >= MIN_Y) {
                        if (checkingTheMaximumNumberOfAnimalSpecies(animal1, islandLocations, countAnimalMax, cellX, cellY - numberOfStep)) {
                            islandLocations[cellY - numberOfStep][cellX].addAnAnimalToACell(animal1);
                            animal.remove(animal1);
                        }
                    }
                } else if (directionOfMovement.equals(Direction.RIGHT)) {
                    if ((cellY - numberOfStep) >= CELL_MAX_X) {
                        if (checkingTheMaximumNumberOfAnimalSpecies(animal1, islandLocations, countAnimalMax, cellX + numberOfStep, cellY)) {
                            islandLocations[cellY][cellX + numberOfStep].addAnAnimalToACell(animal1);
                            animal.remove(animal1);
                        }
                    }
                } else if (directionOfMovement.equals(Direction.DOWN)) {
                    if ((cellY - numberOfStep) >= CELL_MAX_Y) {
                        if (checkingTheMaximumNumberOfAnimalSpecies(animal1, islandLocations, countAnimalMax, cellX, cellY + numberOfStep)) {
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
            }

        }


    }

}
