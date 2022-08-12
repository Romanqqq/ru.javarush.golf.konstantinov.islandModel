package animal.herbivore;

import animal.Herbivore;
import plant.Plant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//Утка
public class Duck extends Herbivore {
    private final int maxQuantityTypeAnimal = 200; // максимальное количество одного вида в ячейке
    private double saturation;

    public Duck() {
        super(4, 1, 0.15);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }


    public void eat(List<?> plants, List<?> herbivores) {
        if (getSaturation() <= getSaturationMax() / 2 /*&& getMovementSpeed() != 0*/) {
            while (getSaturation() <= getSaturationMax()) {
                int chanceEat = ThreadLocalRandom.current().nextInt(100);
                int listPlants = plants.size();
                if (chanceEat > 50 && listPlants > 0) {
                    this.setSaturation(getSaturation() + 1);
                    plants.remove(1);
                } else {
                    for (Object herbivore : herbivores) {
                        Herbivore herbivoreCaterpillar = (Herbivore) herbivore;
                        if (herbivoreCaterpillar.getClass().getSimpleName().equals("Caterpillar")) {
                            herbivores.remove(herbivore);
                            this.setSaturation(getSaturation() + 0.01);
                        }
                    }
                }
            }
        }
    }
}

//    public void eat(List<Plant> plants,List<Herbivore>herbivores) {
//
//    }


//ест гусеницу