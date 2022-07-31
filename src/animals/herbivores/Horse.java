package animals.herbivores;
//Лошадь
public class Horse extends Herbivore  {
    private final int maxQuantityTypeAnimal=20; // максимальное количество одного вида в ячейке
    private double saturation;

    public Horse() {
        super(4, 400, 60);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
