package animals;

public abstract class Animals {
    int movementSpeed; // скорость передвижения
    int weight; // вес животного кг
    int maxQuantityTypeAnimal; // максимальное количество одного вида в ячейке
    double saturationMax; //насыщение животного
    double saturation;

    public Animals(int movementSpeed, int weight, int maxQuantityTypeAnimal, double saturationMax) {
        this.movementSpeed = movementSpeed;
        this.weight = weight;
        this.maxQuantityTypeAnimal = maxQuantityTypeAnimal;
        this.saturationMax = saturationMax;
    }

    //перемещение
    public void move(){
        

    }

    //поесть
    public void eat(){

    }

    //размножение
    public void reproduction(){

    }


}
