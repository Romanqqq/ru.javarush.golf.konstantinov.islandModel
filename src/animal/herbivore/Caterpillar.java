package animal.herbivore;
//Гусеница
public class Caterpillar extends Herbivore  {
    private final int maxQuantityTypeAnimal=1000; // максимальное количество одного вида в ячейке
    private double saturation;

    public Caterpillar() {
        super(0, 0.01, 0);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
