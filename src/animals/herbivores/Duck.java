package animals.herbivores;

import animals.Animals;
import animals.predators.Predator;
import plants.Plants;

import java.util.List;
//Утка
public class Duck extends Animals {
    private final int maxQuantityTypeAnimal=200; // максимальное количество одного вида в ячейке
    private double saturation;

    public Duck() {
        super(4, 1, 0.15);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }


//    public void eat(List<Plants> plants,List<Herbivore>herbivores) {
//
//    }

}
//ест гусеницу