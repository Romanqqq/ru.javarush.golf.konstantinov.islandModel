package animals.herbivores;

import animals.Animals;
import plants.Plants;

import java.util.List;

public class Goat extends Animals implements Herbivore {
    //задал основные характеристики
    private final int maxQuantityTypeAnimal=140; // максимальное количество одного вида в ячейке
    private double saturation;
    public Goat() {
        super(3, 60, 10);
    }
    @Override
    public void eat(List<Plants> plants) {

    }

}
