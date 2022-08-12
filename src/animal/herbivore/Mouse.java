package animal.herbivore;

import animal.Herbivore;
import plant.Plant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//Мышь
public class Mouse extends Herbivore {
    private final int maxQuantityTypeAnimal=500; // максимальное количество одного вида в ячейке
    private double saturation;

    public Mouse() {
        super(1, 0.05, 0.01);
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
//ест гусеницу