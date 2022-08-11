package plant;

public class Plant {
private final int weight=1;// вес одного растения 1 кг
private static final int maxQuantity= 200;// максимальное количество в ячейке
    //создал геттеры
    public int getWeight() {
        return weight;
    }
    public static int getMaxQuantity() {
        return maxQuantity;
    }
}
