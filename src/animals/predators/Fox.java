package animals.predators;
//Лиса
public class Fox extends Predator {
    private final int maxQuantityTypeAnimal=30; // максимальное количество одного вида в ячейке
    private double saturation;

    public Fox() {
        super(2, 8, 2);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
