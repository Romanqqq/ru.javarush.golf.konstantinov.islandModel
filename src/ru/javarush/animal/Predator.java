package ru.javarush.animal;

import ru.javarush.parameter.Info;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Predator extends Animal implements Raptor {
    public Predator(int movementSpeed, double weight, double saturationMax, int hungryAnimalTime) {
        super(movementSpeed, weight, saturationMax, hungryAnimalTime);
    }

    @Override
    public void eat(List<?> foodList, List<?> listFood) {
        try {
            Map<String, Integer> mapHuntChance = null;
            List<String> huntObject = null;
            String animalEat;
            int randomAnimal;
            int chanceEat = ThreadLocalRandom.current().nextInt(0, 100);

            if (this.getHungryAnimalTime() == 0) {
                if (this.getClass().getSimpleName().equals("Bear")) {
                    mapHuntChance = Info.bearEat;
                } else if (this.getClass().getSimpleName().equals("Boa")) {
                    mapHuntChance = Info.boaEat;
                } else if (this.getClass().getSimpleName().equals("Eagle")) {
                    mapHuntChance = Info.eagleEat;
                } else if (this.getClass().getSimpleName().equals("Fox")) {
                    mapHuntChance = Info.foxEat;
                } else if (this.getClass().getSimpleName().equals("Wolf")) {
                    mapHuntChance = Info.wolfEat;
                }

                if (mapHuntChance != null) {
                    huntObject = mapHuntChance.entrySet().stream().filter(value -> chanceEat <= value.getValue()).
                            map(Map.Entry::getKey).collect(Collectors.toList());
                }
                if (huntObject != null && huntObject.size() > 0) {
                    randomAnimal = ThreadLocalRandom.current().nextInt(0, huntObject.size());
                    animalEat = huntObject.get(randomAnimal);
                    for (Object herbivore : foodList) {
                        Animal herbivoreAnimal = (Animal) herbivore;
                        if (animalEat.equals(herbivoreAnimal.getClass().getSimpleName())) {
                            foodList.remove(herbivore);
                        } else {
                            for (Object predator : listFood) {
                                Animal predatorAnimal = (Animal) predator;
                                if (animalEat.equals(predatorAnimal.getClass().getSimpleName())) {
                                    listFood.remove(predator);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}