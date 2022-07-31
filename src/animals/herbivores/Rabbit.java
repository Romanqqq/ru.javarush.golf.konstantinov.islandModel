package animals.herbivores;

import animals.Animals;
import island.Island;
import plants.Plants;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
//Кролик
public class Rabbit extends  Herbivore{
    //задал основные характеристики
    private final int maxQuantityTypeAnimal=150; // максимальное количество одного вида в ячейке
    private double saturation;
    public Rabbit() {
        super(2, 2, 0.45);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }



    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }
}
