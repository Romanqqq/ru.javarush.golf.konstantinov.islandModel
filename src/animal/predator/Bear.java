package animal.predator;
//Медведь
public class Bear extends Predator{
    private final int maxQuantityTypeAnimal=5; // максимальное количество одного вида в ячейке
    private double saturation;

    public Bear() {
        super(2, 500, 80);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
