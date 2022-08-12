package animal;
import animal.Animal;
import parameter.MapChance;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public abstract class Predator extends Animal {
    public Predator(int movementSpeed, double weight, double saturationMax) {
        super(movementSpeed, weight, saturationMax);
    }

    //метод eat для хищников
@Override
    public void eat(List<?> huntObjectHerbivore, List<?> huntObjectPredator) {
        //создаем мапу, в которую попадут все животные, которых можно съесть
        Map<String, Integer> mapHuntChance = null;
        List<String> huntObject = null;
        if (getSaturation() <= getSaturationMax() / 2 /*&& getMovementSpeed() != 0*/) {
            int chanceEat = ThreadLocalRandom.current().nextInt(100);
            //если хищник совпадает по equals, то помещаем в мапу значения из мапы хищника
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

            while (getSaturation() <= getSaturationMax()) {
                String animalEat = null;
                //из мапы вытаскиваем тех животных, чей шанс охоты равен или меньше чем chanceEat
                if (mapHuntChance != null) {
                    huntObject = mapHuntChance.entrySet().stream().filter(value -> value.getValue() <= chanceEat).
                            map(Map.Entry::getKey).collect(Collectors.toList());
                }
                //если список не пустой и больше нуля,то
                if (huntObject != null && huntObject.size() > 0) {
                    //из списка,где шанс быть съедеными меньше chanceEat, рандомно выбираем кого съесть
                    int randomAnimal = ThreadLocalRandom.current().nextInt(0, huntObject.size());
                    animalEat = huntObject.get(randomAnimal);
                }
                //Проверяем список травоядных ищем совпадения по имени, если нет, то проверяем список хищников

                for (Object herbivore : huntObjectHerbivore) {
                    Animal herbivoreAnimal = (Animal) herbivore;
                    if (animalEat.equals(herbivoreAnimal.getClass().getSimpleName())) {
                        huntObjectHerbivore.remove(herbivore);
                        if (MapChance.eaten.keySet().equals(herbivoreAnimal)) {
                            List<Double> eatenAnimal = null;
                            eatenAnimal = new ArrayList<>(MapChance.eaten.values());
                            //добавить если setSaturation> getSaturationMax, то setSaturation=getSaturationMax;
                            this.setSaturation(getSaturation() + eatenAnimal.get(0));//настроить сколько получать за кого

                        } else {
                            for (Object predator : huntObjectPredator) {
                                Animal predatorAnimal = (Animal) predator;
                                if (animalEat.equals(predatorAnimal.getClass().getSimpleName())) {
                                    huntObjectPredator.remove(predator);
                                    if (MapChance.eaten.keySet().equals(herbivoreAnimal)) {
                                        List<Double> eatenAnimal = null;
                                        eatenAnimal = new ArrayList<>(MapChance.eaten.values());
                                        this.setSaturation(getSaturation() + eatenAnimal.get(0));
                                        //настроить сколько получать за кого
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}





