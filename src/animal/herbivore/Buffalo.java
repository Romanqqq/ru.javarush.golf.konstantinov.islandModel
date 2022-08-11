package animal.herbivore;

//Буйвол
public class Buffalo extends Herbivore  {
    private final int maxQuantityTypeAnimal=10; // максимальное количество одного вида в ячейке
    private double saturation;

    public Buffalo() {
        super(3, 700, 100);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }


}
