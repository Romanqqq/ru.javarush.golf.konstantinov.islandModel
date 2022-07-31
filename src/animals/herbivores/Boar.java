package animals.herbivores;
//Кабан
public class Boar extends Herbivore {
    private final int maxQuantityTypeAnimal=50; // максимальное количество одного вида в ячейке
    private double saturation;

    public Boar() {
        super(2, 400, 50);
    }

    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }
}
//ест гусеницу