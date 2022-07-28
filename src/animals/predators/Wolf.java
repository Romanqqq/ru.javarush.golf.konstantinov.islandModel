package animals.predators;


import animals.Animals;
import animals.herbivores.Herbivore;

import java.util.List;

public class Wolf extends Animals implements Predator{
 private final int maxQuantityTypeAnimal=30; // максимальное количество одного вида в ячейке
    private double saturation;

    //задал основные характеристики
    public Wolf() {
        super(3, 50, 8);
    }
    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }

    @Override
    public void eat(List<Herbivore> herbivores) {






    }
}
