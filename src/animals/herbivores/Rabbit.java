package animals.herbivores;

import animals.Animals;
import plants.Plants;

import java.util.List;

public class Rabbit extends Animals implements Herbivore{
    //задал основные характеристики
    private final int maxQuantityTypeAnimal=150; // максимальное количество одного вида в ячейке
    private double saturation;
    public Rabbit() {
        super(2, 2, 0.45);
    }
    @Override
    public void eat(List<Plants> plants) {
    }
    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
