package animals.herbivores;

import animals.Animals;

public class Rabbit extends Animals implements Herbivore{
    //задал основные характеристики
    public Rabbit(int movementSpeed, int weight, int maxQuantityTypeAnimal, double saturationMax) {
        super(2, 2, 150, 0.45);
    }
}
