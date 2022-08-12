package animal.predator;

import animal.Predator;

//Удав
public class Boa extends Predator {
    private final int maxQuantityTypeAnimal=30; // максимальное количество одного вида в ячейке
    private double saturation;

    public Boa() {
        super(1, 15, 3);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
