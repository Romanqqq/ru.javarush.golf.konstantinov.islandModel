package animals.herbivores;
//Мышь
public class Mouse extends Herbivore {
    private final int maxQuantityTypeAnimal=500; // максимальное количество одного вида в ячейке
    private double saturation;

    public Mouse() {
        super(1, 0.05, 0.01);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
//ест гусеницу