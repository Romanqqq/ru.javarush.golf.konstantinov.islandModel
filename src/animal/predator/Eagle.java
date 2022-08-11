package animal.predator;
//Орел
public class Eagle extends Predator {
    private final int maxQuantityTypeAnimal=20; // максимальное количество одного вида в ячейке
    private double saturation;

    public Eagle() {
        super(3, 6, 1);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
