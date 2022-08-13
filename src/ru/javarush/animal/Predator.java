package ru.javarush.animal;

import ru.javarush.parameter.MapChance;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Predator extends Animal implements Predators {
    public Predator(int movementSpeed, double weight, double saturationMax, int hungryAnimalTime) {
        super(movementSpeed, weight, saturationMax, hungryAnimalTime);
    }

    @Override
    public void eat(List<?> huntObjectHerbivore, List<?> huntObjectPredator) {
        try {
            Map<String, Integer> mapHuntChance = null;
            List<String> huntObject = null;
            String animalEat;
            int chanceEat = ThreadLocalRandom.current().nextInt(0, 100);
            if (this.getHungryAnimalTime() == 0) {
                if (this.getClass().getSimpleName().equals("Bear")) {
                    mapHuntChance = MapChance.bearEat;
                } else if (this.getClass().getSimpleName().equals("Boa")) {
                    mapHuntChance = MapChance.boaEat;
                } else if (this.getClass().getSimpleName().equals("Eagle")) {
                    mapHuntChance = MapChance.eagleEat;
                } else if (this.getClass().getSimpleName().equals("Fox")) {
                    mapHuntChance = MapChance.foxEat;
                } else if (this.getClass().getSimpleName().equals("Wolf")) {
                    mapHuntChance = MapChance.wolfEat;
                }

                if (mapHuntChance != null) {
                    huntObject = mapHuntChance.entrySet().stream().filter(value -> chanceEat <= value.getValue()).
                            map(Map.Entry::getKey).collect(Collectors.toList());
                }
                if (huntObject != null && huntObject.size() > 0) {
                    int randomAnimal = ThreadLocalRandom.current().nextInt(0, huntObject.size());
                    animalEat = huntObject.get(randomAnimal);
                    for (Object herbivore : huntObjectHerbivore) {
                        Animal herbivoreAnimal = (Animal) herbivore;
                        if (animalEat.equals(herbivoreAnimal.getClass().getSimpleName())) {
                            huntObjectHerbivore.remove(herbivore);
                        } else {
                            for (Object predator : huntObjectPredator) {
                                Animal predatorAnimal = (Animal) predator;
                                if (animalEat.equals(predatorAnimal.getClass().getSimpleName())) {
                                    huntObjectPredator.remove(predator);
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