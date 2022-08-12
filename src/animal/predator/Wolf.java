package animal.predator;


import animal.Predator;

//Волк
public class Wolf extends Predator {
 private final int maxQuantityTypeAnimal=30; // максимальное количество одного вида в ячейке
    private double saturation;

    //задал основные характеристики
    public Wolf() {
        super(3, 50, 8);
    }
    public int getMaxQuantityTypeAnimal() {
        return maxQuantityTypeAnimal;
    }



}






