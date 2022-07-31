package animals.predators;


import animals.Animals;
import animals.herbivores.Herbivore;
import plants.Plants;

import java.util.List;
//Волк
public class Wolf extends Animals{
 private final int maxQuantityTypeAnimal=30; // максимальное количество одного вида в ячейке
    private double saturation;

    //задал основные характеристики
    public Wolf() {
        super(3, 50, 8);
    }
    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }



}






