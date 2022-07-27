package animals.predators;


import animals.Animals;

public class Wolf extends Animals implements Predator {
    //задал основные характеристики
    public Wolf(int movementSpeed, int weight, int maxQuantityTypeAnimal, double saturationMax) {
        super(3, 50, 30, 8);
    }
}
