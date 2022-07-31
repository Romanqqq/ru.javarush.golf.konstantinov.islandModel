package animals.herbivores;

import animals.Animals;
import island.Island;
import plants.Plants;

import java.awt.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animals {
    Island island = new Island();

    public Herbivore(int movementSpeed, double weight, double saturationMax) {
        super(movementSpeed, weight, saturationMax);
    }

    //    реализовал метод eat для травоядных
    public void eat(List<Plants> plants) {
        //если насыщение упало до 50%, то едим растение и насыщение становится 100%, съеденное растение удаляем
        //за 1 шаг, можно поесть 1 раз, подумать как реализовать  выбор или есть или идти
//        for (int i = getMovementSpeed(); i <= getMovementSpeed(); i--) {
            if (getSaturation() <= getSaturationMax() / 2 /*&& getMovementSpeed() != 0*/) {
                while (getSaturation() <= getSaturationMax()) {
                    int chanceEat = ThreadLocalRandom.current().nextInt(100);
                    int listPlants = plants.size();
                    if (chanceEat > 50 && listPlants > 0) {
                        this.setSaturation(getSaturation() + 1);
                        plants.remove(1);
                    }
                }
            }
        }
    }
//}