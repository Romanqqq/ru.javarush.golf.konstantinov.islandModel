package animals.herbivores;
//Олень
public class Deer extends Herbivore {
    private final int maxQuantityTypeAnimal=20; // максимальное количество одного вида в ячейке
    private double saturation;

    public Deer() {
        super(4, 300, 50);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
