package animal.herbivore;
//Овца
public class Sheep extends Herbivore  {
    private final int maxQuantityTypeAnimal=140; // максимальное количество одного вида в ячейке
    private double saturation;

    public Sheep() {
        super(3, 70, 15);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
